package com.hellocoder.renthouse.service;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Paid;
import com.hellocoder.renthouse.Pojo.QueryVo;
import com.hellocoder.renthouse.Pojo.Topaid;

public interface TopaidService {
	public void inserttopaid(Topaid topaid);
	public List<Topaid> findtopaid(QueryVo vo);
	public Topaid findbyid(Integer id);
	public void gotopay(Integer id,Paid paid);
}
