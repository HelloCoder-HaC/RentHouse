package com.hellocoder.renthouse.service;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Paid;
import com.hellocoder.renthouse.Pojo.QueryVo;
import com.hellocoder.renthouse.Pojo.Zulist;

public interface PaidService {
	public List<Paid> selectall(QueryVo vo);
	public Double selectsum(QueryVo vo);
	public void deletepaid(Integer id);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzukezulist(Integer id);
	
}
