package com.test.kafka_producer;

import java.util.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

         
                                    
                String topicName="SimpleProducerTopic";
                String groupName="SupplierTopicGroup";
                                
                Properties props =new Properties();
                props.put("bootstrap.servers","localhost:9092,localhost:9093");
                props.put("group.id",groupName);
                props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
                props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
                                
                KafkaConsumer<String, String> consumer =new KafkaConsumer<String, String>(props);
                consumer.subscribe(Arrays.asList(topicName));
                System.out.println("printing topic");                
                while(true){
                    ConsumerRecords<String, String> records =consumer.poll(100);
                    
                        
                        for (ConsumerRecord<String, String> record : records){
                        	
                        // print the offset,key and value for the consumer records.
                        System.out.printf("offset = %d, key = %s, value = %s\n",
                           record.offset(), record.key(), record.value());}
                    }
                }                                
            }
                                                         
                                
       

