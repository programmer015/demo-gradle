package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.dto.QuestionAnswerDTO;
import com.thinkinnovative.demo_gradle.dto.SubjectTopicDTO;
import com.thinkinnovative.demo_gradle.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findBySubjectId(Integer subjectId);
    @Query("SELECT new com.thinkinnovative.demo_gradle.dto.SubjectTopicDTO(" +
            "t.subject.subjectName, t.topicName)"+" FROM Topic t")
    List<SubjectTopicDTO> findAllSubjectTopic();
}
