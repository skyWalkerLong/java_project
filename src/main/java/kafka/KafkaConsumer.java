package kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author longchao
 * @date 2018/5/30.
 */
public class KafkaConsumer {
    private  final ConsumerConnector consumer;

    public final static String TOPIC="TEST-TOPIC4";

    private KafkaConsumer(){
        Properties props=new Properties();
        props.put("zookeeper.connect","116.196.81.252:2181");
        props.put("group.id","test");

        props.put("zookeeper.session.timeout.ms","60000");
        props.put("zookeeper.sync.time.ms","200");
        props.put("auto.commit.interval.ms","1000");
        props.put("auto.offset.reset","smallest");
        props.put("max.poll.interval.ms",3000);
        props.put("max.poll.records",3);

        props.put("serializer.class","kafka.serializer.StringEncoder");

        ConsumerConfig config=new ConsumerConfig(props);

        consumer=kafka.consumer.Consumer.createJavaConsumerConnector(config);
    }


    void consume() throws InterruptedException {
        Map<String,Integer> topicCountMap=new HashMap<String, Integer>();
        topicCountMap.put(KafkaConsumer.TOPIC,new Integer(1));
        StringDecoder keyDecoder=new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder=new StringDecoder(new VerifiableProperties());

        Map<String,List<KafkaStream<String,String>>> consumerMap=
                consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
        KafkaStream<String,String> stream=consumerMap.get(KafkaConsumer.TOPIC).get(0);
        ConsumerIterator<String,String> it=stream.iterator();
        System.out.println("recive");
        while(it.hasNext()){
            System.out.println(it.next().message());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new KafkaConsumer().consume();
    }
}
