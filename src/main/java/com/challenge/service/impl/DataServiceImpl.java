package com.challenge.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.domain.Data;
import com.challenge.repository.DataRepository;
import com.challenge.service.DataService;

@Transactional
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataRepository repository;
	
	@Override
	public List<Data> findAll() {
		return repository.findAll();
	}

	@Override
	public Data findById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Data> findAllByTimeStampBetween(Date startDate, Date endDate) {
		return repository.findAllByTimeStampBetween(startDate, endDate);
	}

	@Override
	public Data save(Data data) {
		return repository.save(data);
	}

}
