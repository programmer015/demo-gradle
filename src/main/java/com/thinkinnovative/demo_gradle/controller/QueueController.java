package com.thinkinnovative.demo_gradle.controller;


import com.thinkinnovative.demo_gradle.dto.QueueDTO;
import com.thinkinnovative.demo_gradle.entity.Queue;
import com.thinkinnovative.demo_gradle.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/queue")
public class QueueController {

    public final   QueueService queue;

    @Autowired
    public QueueController(QueueService queue) {
        this.queue = queue;
    }

    @PostMapping("/bymember")
    public List<QueueDTO> queuebybookid(@RequestBody Map<String, Integer> request)
    {
        Integer bookID = request.get("bookid");
        return queue.queueByBookid(bookID);
    }

//    public QueueController(QueueService queue) {
//        this.queue = queue;
//    }
}
