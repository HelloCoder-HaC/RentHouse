package com.hellocoder.renthouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hellocoder.renthouse.Pojo.Schedule;
import com.hellocoder.renthouse.dao.ScheduleMapper;
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleMapper scheduleMapper;
	@Override
	public void insertschedule(Schedule schedule) {
		scheduleMapper.insertschedule(schedule);
		
	}

	@Override
	public List<Schedule> selectAll() {
		List<Schedule> list=scheduleMapper.selectAll();
		return list;
	}

	@Override
	public void deleteschedule(Integer id) {
		scheduleMapper.deleteschedule(id);
		
	}

	@Override
	public void updateschedule(Schedule schedule) {
		scheduleMapper.updateschedule(schedule);
		
	}

	@Override
	public Schedule selectbyid(Integer id) {
		Schedule schedule=scheduleMapper.selectbyid(id);
		return schedule;
	}

}
