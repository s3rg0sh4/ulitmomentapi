package com.ulitmoment.repos;

import com.ulitmoment.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic, Long> {

}
