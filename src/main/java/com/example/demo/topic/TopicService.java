package com.example.demo.topic;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	
@Autowired
private TopicRepository topicRepository;


	private List <Topic> A= new ArrayList<>(Arrays.asList(
			new Topic("java","core java","java descrption"),
					new Topic("spring","spring boot","spring descrption")
			));
	public List<Topic> getAllTopics(){
	List<Topic> topics=new ArrayList<>();
	topicRepository.findAll().forEach(topics::add);
	System.out.println("this is from service");
	return topics;
		
	}
	public Topic getTopic(String id) {
		//return A.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).orElse(null);
	}
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		
	}
	
}
