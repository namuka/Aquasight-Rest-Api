package com.challenge.service;

import java.util.Date;
import java.util.List;

import com.challenge.domain.Data;

public interface DataService {
	public List<Data> findAll();
	public Data findById(int id);
	public List<Data> findAllByTimeStampBetween(Date startDate, Date endDate);
	public Data save(Data data);
}
