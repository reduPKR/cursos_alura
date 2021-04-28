package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        try(var dispatcher = new KafkaDispatcher()){
            for (int i = 0; i < 100; i++) {
                var key = UUID.randomUUID().toString();
                String value = key + ",67890,12345";//Por ser teste vai representar a chave e o valor
                String email = "Estamos processando seu pedido";

                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
            }
        }
    }
}
