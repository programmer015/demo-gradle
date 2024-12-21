package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.entity.StatusTable;
import com.thinkinnovative.demo_gradle.repository.StatusTableRepository;
import com.thinkinnovative.demo_gradle.service.StatusTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusTableServiceImpl implements StatusTableService {
    private final StatusTableRepository statusRepository;

    @Autowired
    public StatusTableServiceImpl(StatusTableRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public StatusTable addStatus(StatusTable statusTable) {
        return statusRepository.save(statusTable);
    }
}
