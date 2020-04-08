package com.JAVA.TEST.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JAVA.TEST.model.Work;
import com.JAVA.TEST.repository.WorkRepository;
import com.JAVA.TEST.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService{
	private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl (WorkRepository workRepository){
        this.workRepository = workRepository;
    }

	@Override
	public List<Work> findAllWorks() {
		return workRepository.findAll();
	}

	@Override
	public Optional<Work> findById(Integer id) {
		return workRepository.findById(id);
	}

	@Override
	public void save(Work work) {
		workRepository.save(work);
	}

	@Override
	public void remove(Work work) {
		workRepository.delete(work);
	}

    
}
