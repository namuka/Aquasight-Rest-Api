package com.challenge.controller;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.domain.Data;
import com.challenge.exception.InvalidDataException;
import com.challenge.service.DataService;

@RestController
public class DataController {
	
	@Autowired
	private DataService service;
	
	@GetMapping("/")
	public String home() {
		return "Welcome!";
	}
	
	@GetMapping("/list")
	public List<Data> getAll(
			@RequestParam(name="start", required=false, defaultValue = "") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam(name="end", required=false, defaultValue = "")  @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
		if(startDate!=null && endDate!=null) 
			return service.findAllByTimeStampBetween(startDate, endDate);
		
		return service.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Data getOne(@PathVariable int id) {
		return service.findById(id);
	}
			
	@PostMapping("/add")
	public Data addData(@Valid @RequestBody Data data, Errors errors) {
		if(errors.hasErrors()) throw new InvalidDataException();
		return service.save(data);
	}
}
