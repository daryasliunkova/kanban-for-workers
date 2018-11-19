package com.dsliunkova.kanbanforworkers.services;

import com.dsliunkova.kanbanforworkers.entities.Case;
import com.dsliunkova.kanbanforworkers.repositories.CaseRepository;
import com.google.common.collect.Lists;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    private CaseRepository caseRepository;

    public CaseService() {

    }

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> getCases() {
        return Lists.newArrayList(caseRepository.findAll());
    }
}
