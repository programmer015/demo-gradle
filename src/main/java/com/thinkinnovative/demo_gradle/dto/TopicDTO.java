package com.thinkinnovative.demo_gradle.dto;


import com.thinkinnovative.demo_gradle.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicDTO {

    private String topicName;
    private Integer subjectId;
}
