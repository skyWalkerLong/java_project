package kafka;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ProducerFastStart {
    public static final String brokerList = "";
    public static final String topic = "test";

    public static Properties initConfig(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer.client.id.demo");
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, DemoPartitioner.class.getName());
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, ProducerInterceptorPrefix.class.getName());
        return props;
    }

    public static void main(String[] args) {
        Properties props = initConfig();
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record =
                new ProducerRecord<>(topic, "3");
        try {
            Future<RecordMetadata> future = producer.send(record);
            RecordMetadata metadata = future.get();
            System.out.println(metadata.topic() + "-" + metadata.partition() + "-" + metadata.offset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
