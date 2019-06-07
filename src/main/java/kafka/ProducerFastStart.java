package kafka;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ProducerFastStart {
    public static final String brokerList = "39.96.11.146:9092";
    public static final String topic = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);

        KafkaProducer<String, String> producer = null;
        try{
            producer = new KafkaProducer<>(properties);
            System.out.print("1");
            ProducerRecord<String, String> record =
                    new ProducerRecord<>(topic, "hello, Kafka!");
            System.out.print("2");

            Future future = producer.send(record);
            System.out.print("3");

            future.get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.print(e);
        }

        producer.close();
    }
}
