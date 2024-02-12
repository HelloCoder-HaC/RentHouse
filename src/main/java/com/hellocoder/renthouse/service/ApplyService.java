package com.hellocoder.renthouse.service;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Apply;
import com.hellocoder.renthouse.Pojo.Houselist;

public interface ApplyService {
	
	public void insertapply(Apply apply);
	public List<Apply> findapplylist() throws Exception;
	Apply findbyhouse_id(String house_id);
	public void deletebyhouse_id(String house_id);
	public void refuseapply(Houselist houselist,String name);
	public List<Apply> findallapplyout();
}
