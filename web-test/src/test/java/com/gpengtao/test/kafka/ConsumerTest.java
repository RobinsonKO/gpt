package com.gpengtao.test.kafka;

import com.google.common.collect.Maps;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by gpengtao on 15/10/14.
 */
public class ConsumerTest {

    private Properties properties;

    @Before
    public void init_properties() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "10.86.36.15:2181");
        props.put("group.id", "dev-test-consumer-1");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        properties = props;
    }

    @Test
    public void test_consumer() {
        ConsumerConfig config = new ConsumerConfig(properties);

        ConsumerConnector connector = Consumer.createJavaConsumerConnector(config);

        String topic = "just_test";

        Map<String, Integer> topicCountMap = Maps.newHashMap();
        topicCountMap.put(topic, 1);

        Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = connector.createMessageStreams(topicCountMap);

        List<KafkaStream<byte[], byte[]>> kafkaStreams = messageStreams.get(topic);

        KafkaStream<byte[], byte[]> kafkaStream = kafkaStreams.get(0);
        ConsumerIterator<byte[], byte[]> consumerIterator = kafkaStream.iterator();
        while (consumerIterator.hasNext()) {
            MessageAndMetadata<byte[], byte[]> messageAndMetadata = consumerIterator.next();
            byte[] key = messageAndMetadata.key();// 貌似会阻塞。。
            System.out.println("key:" + (key == null ? "null" : new String(key)));

            byte[] message = messageAndMetadata.message();
            System.out.println("message:" + (message == null ? "null" : new String(message)));
        }

        shutDown(connector);

    }

    private static void shutDown(ConsumerConnector connector) {
        if (connector != null) {
            connector.shutdown();
        }

    }
}
