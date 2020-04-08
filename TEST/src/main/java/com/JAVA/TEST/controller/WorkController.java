package com.JAVA.TEST.controller;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.JAVA.TEST.model.Work;
import com.JAVA.TEST.service.WorkService;

@RestController
@RequestMapping("/api")
public class WorkController {

	private final WorkService workService;
	
	@Autowired
	public WorkController(WorkService workService) {
		this.workService = workService;
	}
	
	@GetMapping("/works")
	public ResponseEntity<List<Work>> getWorks() {
		List<Work> works = workService.findAllWorks();
    	return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
	}
	
	@PostMapping("/work/add")
	public ResponseEntity<Work> createWork(@RequestBody Work work) {
		work.setDateStart(new Date());
		work.setDateEnd(new Date());
		workService.save(work);
        return new ResponseEntity<>(work, HttpStatus.CREATED);
    }
	
	@PostMapping("/work/update/{id}")
	public ResponseEntity<Work> updateWork(@PathVariable("id") Integer id, @RequestBody Work work) {
		Optional<Work> currentWork = workService.findById(id);
		if (!currentWork.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		work.setDateStart(new Date());
		work.setDateEnd(new Date());
        currentWork.get().setWorkName(work.getWorkName());
        currentWork.get().setDateStart(work.getDateStart());
        currentWork.get().setDateEnd(work.getDateEnd());
        currentWork.get().setStatus(work.getStatus());
        workService.save(currentWork.get());
        return new ResponseEntity<>(currentWork.get(), HttpStatus.OK);
    }
	
	@DeleteMapping("/work/delete/{id}")
	public ResponseEntity<Work> deleteWork(@PathVariable("id") Integer id) {
		Optional<Work> currentWork = workService.findById(id);
		if (!currentWork.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        workService.remove(currentWork.get());
        return new ResponseEntity<>(currentWork.get(), HttpStatus.OK);
    }

}
