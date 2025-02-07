package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.*;
import com.thinkinnovative.demo_gradle.entity.QuestionAnswer;
import com.thinkinnovative.demo_gradle.entity.Subject;
import com.thinkinnovative.demo_gradle.entity.Topic;
import com.thinkinnovative.demo_gradle.repository.QuestionAnswerRepository;
import com.thinkinnovative.demo_gradle.repository.SubjectRepository;
import com.thinkinnovative.demo_gradle.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QAServiceImpl {
    private final SubjectRepository subjectRepository;
    private final TopicRepository topicRepository;
    private final QuestionAnswerRepository questionAnswerRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Integer id) {
        return subjectRepository.findById(id);
    }

    public String addSubject(SubjectDTO dto) {
        Subject subject = Subject.builder()
                .subjectName(dto.getSubjectName())
                .build();
        subjectRepository.save(subject);
        return "The subject is added successfully";
    }

    public List<Topic> getTopicsBySubject(Integer subjectId) {
        return topicRepository.findBySubjectId(subjectId);
    }

    public List<QuestionAnswerDTO> getQuestionsByTopic(Integer topicId) {
        return questionAnswerRepository.findByTopic(topicId);
    }
    public String addTopic(TopicDTO dto) {
        Optional<Subject> subject = subjectRepository.findById(dto.getSubjectId());
        Topic topic = Topic.builder()
                .topicName(dto.getTopicName())
                .subject(subject.get())
                .build();
        topicRepository.save(topic);
        return "The topic is successfully added.";
    }

    public String addQuestionAnswer(QADTO dto)
    {
        Optional<Topic> topic = topicRepository.findById(dto.getTopicId());
        QuestionAnswer qa = QuestionAnswer.builder()
                .question(dto.getQuestion())
                .answer(dto.getAnswer())
                .topic(topic.get())
                .build();
        questionAnswerRepository.save(qa);
        return "The question and answer is successfully added.";
    }

    public List<SubjectTopicDTO>findAllSubjectTopic()
    {
        return topicRepository.findAllSubjectTopic();
    }

}
