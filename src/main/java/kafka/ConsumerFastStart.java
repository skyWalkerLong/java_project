package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsumerFastStart {
    public static final String brokerList = "";
    public static final String topic = "test";
    public static final String groupId = "group.demo";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);


    public static Properties initConfig(){
        Properties props = new Properties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "client.id.demo");
        return props;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();
        //创建一个消费者客户端实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        //订阅主题;可以通过正则表达式订阅多个主题；可以通过assign订阅指定分区
        consumer.subscribe(Arrays.asList(topic));

        //另一种订阅方式，通过订阅所有属于该主题的分区来订阅主题
//        List<TopicPartition> partitions = new ArrayList<>();
//        List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);
//        if (partitionInfos != null) {
//            for (PartitionInfo tpInfo : partitionInfos) {
//                partitions.add(new TopicPartition(tpInfo.topic(), tpInfo.partition()));
//            }
//        }
//        consumer.assign(partitions);

        //取消订阅
//        consumer.unsubscribe();


        try {
            while (isRunning.get()) {
                ConsumerRecords<String, String> records =
                        consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic()
                            + ", partition = "+ record.partition()
                            + ", offset = " + record.offset());
                    System.out.println("key = " + record.key()
                            + ", value = " + record.value());
                    //do something to process record.
                }
            }
        } catch (Exception e) {

            System.out.println(e);

        } finally {
            consumer.close();
        }
    }
}
