package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        try(var orderDispatcher = new KafkaDispatcher<Order>()){
            try(var emailDispatcher = new KafkaDispatcher<String>()){
                for (int i = 0; i < 10; i++) {
                    String userId = UUID.randomUUID().toString();
                    String orderId = UUID.randomUUID().toString();
                    BigDecimal amount = new BigDecimal(Math.random() * 4999 + 1);

                    Order order = new Order(userId, orderId, amount);
                    orderDispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);

                    String email = "Estamos processando seu pedido";
                    emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userId, email);
                }
            }
        }
    }
}
