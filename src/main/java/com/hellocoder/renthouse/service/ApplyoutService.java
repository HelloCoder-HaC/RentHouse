package com.hellocoder.renthouse.service;

import com.hellocoder.renthouse.Pojo.Applyout;
import com.hellocoder.renthouse.Pojo.Zulist;

public interface ApplyoutService {
	public void insertapplyout(Zulist zulist);
	public void updateapplyout(Applyout applyout);
	public void agreeapplyout(Integer id);
	public void deleteapplyout(Integer id);
}
