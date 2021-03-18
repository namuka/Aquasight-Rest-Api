package com.challenge.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.domain.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {
	
	public List<Data> findAll();
	public Data findById(int id);
	public List<Data> findAllByTimeStampBetween(Date startDate, Date endDate);
	public Data save(Data data);

}
