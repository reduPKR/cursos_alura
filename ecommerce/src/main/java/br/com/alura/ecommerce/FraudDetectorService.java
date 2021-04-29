package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.util.HashMap;

public class FraudDetectorService {
    public static void main(String[] args) throws IOException {
        var fraudService = new FraudDetectorService();
        try(var service = new KafkaService<Order>(FraudDetectorService.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER",
                fraudService::parse,
                Order.class,
                new HashMap<String,String>())){
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, Order> record){
        System.out.println("***********************************");
        System.out.println("Processando antifraude");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ordem processada");
    }
}
