package com.gpengtao.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by gpengtao on 15/10/13.
 */
public class ConsumerTestNotWork {

    @Test
    public void test() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.86.36.215:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS, "1000");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY, "range");
//      properties.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY, "roundrobin");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<byte[], byte[]>(properties);

        consumer.subscribe("just_test");

        System.out.println(consumer);

        Map<String, ConsumerRecords<byte[], byte[]>> pollData = consumer.poll(1000);

        System.out.println(pollData);
    }

    @Test
    public void consumer() {
        Properties props = new Properties();
        props.put("metadata.broker.list", "10.86.36.215:9092");
        props.put("group.id", "test");
        props.put("session.timeout.ms", "1000");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "10000");
        props.put("key.deserializer", "com.gpengtao.test.kafka.DeserializerImpl");
        props.put("value.deserializer", "com.gpengtao.test.kafka.DeserializerImpl");
        props.put("partition.assignment.strategy", "xxxx");
        props.put("bootstrap.servers", "10.86.36.215:9092");
        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<byte[], byte[]>(props);
        consumer.subscribe("foo", "bar");
        boolean isRunning = true;
        while (isRunning) {
            Map<String, ConsumerRecords<byte[], byte[]>> records = consumer.poll(100);
            process(records);
        }
        consumer.close();
    }


    private Map<TopicPartition, Long> process(Map<String, ConsumerRecords<byte[], byte[]>> records) {
        Map<TopicPartition, Long> processedOffsets = new HashMap<TopicPartition, Long>();
        for (Map.Entry<String, ConsumerRecords<byte[], byte[]>> recordMetadata : records.entrySet()) {
            List<ConsumerRecord<byte[], byte[]>> recordsPerTopic = recordMetadata.getValue().records();
            for (int i = 0; i < recordsPerTopic.size(); i++) {
                ConsumerRecord<byte[], byte[]> record = recordsPerTopic.get(i);
                // process record
                try {
                    processedOffsets.put(record.topicAndPartition(), record.offset());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return processedOffsets;
    }

}
