package com.hellocoder.renthouse.service;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Schedule;

public interface ScheduleService {
	public void insertschedule(Schedule schedule);
	public List<Schedule> selectAll();
	public void deleteschedule(Integer id);
	public void updateschedule(Schedule schedule);
	public Schedule selectbyid(Integer id);
}
