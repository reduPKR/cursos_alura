package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

//Com o T eu posso gerar pedidos de ordem ou strings
public class KafkaDispatcher<T> implements Closeable {
    private final KafkaProducer<String, T> producer;

    public KafkaDispatcher() {
        producer = new KafkaProducer<String,T>(properties());
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,GsonSerializer.class.getName());
        //properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        return properties;
    }

    public void send(String topic, String key, T value) throws ExecutionException, InterruptedException {
        var record = new ProducerRecord<>(topic,key,value);//Ele idendifica que sao duas strings por isso n escrevi
        Callback callback = getCallback();

        producer.send(record, callback).get();
    }

    private static Callback getCallback() {
        return (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Sucesso\n" + data.topic() + "\n" + data.partition() + "\n" + data.offset() + "\n" + data.timestamp());
        };
    }

    @Override
    public void close() throws IOException {
        producer.close();
    }
}
