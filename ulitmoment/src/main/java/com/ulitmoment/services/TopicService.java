package com.ulitmoment.services;

import com.ulitmoment.entities.Topic;
import com.ulitmoment.repos.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepo topicRepo;

    public void updateTopic(Topic topic, String summary, String task, String hint) {
        topic.setSummary(summary);
        topic.setTask(task);
        topic.setHint(hint);
        topicRepo.save(topic);
    }
}
