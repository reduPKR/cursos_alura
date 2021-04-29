package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class KafkaService<T> implements Closeable {
    private final KafkaConsumer<String, T> consumer;
    private final ConsumerFunction parse;

    private KafkaService(String groupId, ConsumerFunction parse, Class<T> type, Map<String,String> properties) {
        this.parse = parse;
        this.consumer = new KafkaConsumer<String, T>(properties(groupId, type, properties));
    }

    public KafkaService(String groupId, String topic, ConsumerFunction parse, Class<T> type, Map<String,String> properties) {
        this(groupId, parse, type, properties);
        consumer.subscribe(Collections.singletonList(topic));
    }

    public KafkaService(String groupId, Pattern topic, ConsumerFunction parse, Class<T> type, Map<String,String> properties) {
        this(groupId, parse, type, properties);
        consumer.subscribe(topic);
    }

    private Properties properties(String groupId, Class<T> type, Map<String, String> overrideProperties) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserializer.class.getName());
        //properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, EmailService.class.getSimpleName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");//Recebe 1 record por vez, isso reduz conflitos
        properties.setProperty(GsonDeserializer.TYPE_CONFIG, type.getName());//criei para deserialização do gson
        properties.putAll(overrideProperties);
        return properties;
    }

    public void run() {
        while (true){
            var records = consumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                System.out.println(records.count()+" registros encontrados");

                for (var record : records) {
                    parse.consume(record);
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        consumer.close();
    }
}
