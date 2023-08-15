package com.nikhil.springboot.courseapi.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    public List<Topic> topics = new ArrayList <> (List.of(
            new Topic("12","Spring Boot", "Demo Spring Boot"),
            new Topic("11","Java", "Demo Java Project"),
            new Topic("13","JS", "Demo JS Project")
        ));

    public List<Topic> getTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id){
        System.out.println("I am here");
        for( int i = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if( t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf(t -> t.getId().equals(id));
    }

}
