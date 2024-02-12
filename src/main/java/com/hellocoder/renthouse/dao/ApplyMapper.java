package com.hellocoder.renthouse.dao;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Apply;
import com.hellocoder.renthouse.Pojo.Applyout;

public interface ApplyMapper {
	void insertapply(Apply apply);
	public List<Apply> findapplylist() throws Exception;
	Apply findbyhouse_id(String house_id);
	public void deletebyhouse_id(String house_id);
	public void updateapplyout(Applyout applyout);
	public void updateapplystatus(Apply apply);
	public List<Apply> findallapplyout();
}
