package com.hellocoder.renthouse.dao;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Schedule;

public interface ScheduleMapper {
	public void insertschedule(Schedule schedule);
	public List<Schedule> selectAll();
	public void deleteschedule(Integer id);
	public void updateschedule(Schedule schedule);
	public Schedule selectbyid(Integer id);
}
