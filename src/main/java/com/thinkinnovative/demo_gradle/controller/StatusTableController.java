package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.entity.StatusTable;
import com.thinkinnovative.demo_gradle.service.StatusService;
import com.thinkinnovative.demo_gradle.service.StatusTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusTableController {
    private final StatusTableService statusTableService;

    @Autowired
    public StatusTableController(StatusTableService statusTableService) {
        this.statusTableService = statusTableService;
    }

    // Endpoint to add a new status
    @PostMapping("/add")
    public StatusTable addStatus(@RequestBody StatusTable statusTable) {
        return statusTableService.addStatus(statusTable);
    }
}
