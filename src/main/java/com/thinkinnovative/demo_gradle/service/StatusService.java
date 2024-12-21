package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.entity.StatusInformation;

import java.util.List;

public interface StatusService {
    public String addStatus(StatusInformation statusInformation);
    public List<StatusInformation> getStatus();
}
