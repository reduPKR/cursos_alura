package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
                         //KafkaProducer<Key, Value> -> do metodo properties
        var producer = new KafkaProducer<String,String>(properties());
        String value = "1234,4567,7890";//Por ser teste vai representar a chave e o valor

        //var record = new ProducerRecord<String, String>("ECOMMERCE_NEW_ORDER",value,value);
        var record = new ProducerRecord<>("ECOMMERCE_NEW_ORDER",value,value);//Ele idendifica que sao duas strings por isso n escrevi

        //producer.send(record).get();
        //producer.send(record).get();//Com o get avisa que esta espereando a resposta
        producer.send(record, (data, ex) ->{
            if(ex != null){
                ex.printStackTrace();
                return;
            }
            System.out.println("Sucesso\n"+data.topic()+"\n"+data.partition()+"\n"+data.offset()+"\n"+data.timestamp());
        }).get();//Alem de esperar a resposta eu quero exibir o resultado.
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        return properties;
    }


}
