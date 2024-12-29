package com.thinkinnovative.demo_gradle.dto;

public class QueueDTO {
    private Integer queue_id;
    private Integer member_id;
    private Integer position;
    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getQueue_id() {
        return queue_id;
    }

    public void setQueue_id(Integer queue_id) {
        this.queue_id = queue_id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public QueueDTO(Integer queue_id, Integer member_id, Integer position) {
        this.queue_id = queue_id;
        this.member_id = member_id;
        this.position = position;
    }
}
