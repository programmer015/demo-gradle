package com.thinkinnovative.demo_gradle.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class WidgetDTO {

    private String widget_name;

    private String description;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private Integer is_active;

    private String icon;

    private String backgroundColor;

//    private String onClickPath;
//
//    private String isCommon;

    private String type;

    private String color;


}
