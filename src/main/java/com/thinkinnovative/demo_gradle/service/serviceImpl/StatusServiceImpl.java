package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.entity.StatusInformation;
import com.thinkinnovative.demo_gradle.repository.StatusRepository;
import com.thinkinnovative.demo_gradle.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @Override
    public String addStatus(StatusInformation statusInformation) {
        statusRepository.save(statusInformation);
        return "Status added successfully";
    }

    @Override
    public List<StatusInformation>getStatus() {
        return statusRepository.findAll();
    }
}
