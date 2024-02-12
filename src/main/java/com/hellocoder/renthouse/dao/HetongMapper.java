package com.hellocoder.renthouse.dao;

import com.hellocoder.renthouse.Pojo.Hetong;

public interface HetongMapper {
	
	public void inserthetong(Hetong hetong);
	public Hetong findhetong(String house_id);
	public void updatehetong(Hetong hetong);
	public void deletehetong(String house_id);
}
