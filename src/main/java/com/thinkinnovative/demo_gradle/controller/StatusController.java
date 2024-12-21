package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.entity.StatusInformation;
import com.thinkinnovative.demo_gradle.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    StatusService service;
    public StatusController(StatusService service) {
        this.service = service;
    }
@PostMapping("/addStatus")
    public String addStatus(@RequestBody StatusInformation statusInformation) {

       return service.addStatus(statusInformation);
    }
    @GetMapping("/getStatus")
    public List<StatusInformation> getStatus()
    {
        return service.getStatus();
    }



}
