package com.test.kafka;
import org.apache.kafka.clients.producer.*;  
import java.util.*;
import java.util.concurrent.*;
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	                                  
        
              String key = "Key1";
                String value = "message test:";
                String topicName = "SimpleProducerTopic";
             //defining properties for kafka  
                                
              Properties props = new Properties();
                props.put("bootstrap.servers", "localhost:9092,localhost:9093");
                props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
                props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            //creating kafka producer
                Producer<String, String> producer = new KafkaProducer<String, String>(props);                    
            //sending messages  
                for(int s=0;s<=10;s++){      
                                      
              ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName,key,value+Integer.toString(s));
              System.out.println("sending producer");
              producer.send(record);                
              TimeUnit.SECONDS.sleep(1);
                System.out.println("SimpleProducer Completed.");
            }
              producer.close();
            
    }
    }

