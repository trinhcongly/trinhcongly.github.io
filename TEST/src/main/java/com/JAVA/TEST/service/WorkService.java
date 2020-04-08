package com.JAVA.TEST.service;

import java.util.List;
import java.util.Optional;

import com.JAVA.TEST.model.Work;

public interface WorkService {
	List<Work> findAllWorks();
    Optional<Work> findById(Integer id);
	void save(Work work);
	void remove(Work work);
}
