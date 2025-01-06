package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.dto.QueueDTO;
import com.thinkinnovative.demo_gradle.entity.Queue;

import java.util.List;

public interface QueueService {

    public String addQueue(Integer bookId, Integer memberId);
    public List<QueueDTO> queueByBookid(Integer bookId);
}
