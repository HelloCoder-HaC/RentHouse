package com.hellocoder.renthouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hellocoder.renthouse.Pojo.Paid;
import com.hellocoder.renthouse.Pojo.QueryVo;
import com.hellocoder.renthouse.Pojo.Topaid;
import com.hellocoder.renthouse.dao.PaidMapper;
import com.hellocoder.renthouse.dao.TopaidMapper;

@Service
@Transactional
public class TopaidServiceImpl implements TopaidService {
	@Autowired
	private TopaidMapper topaidMapper;
	@Autowired
	private PaidMapper paidMapper;
	@Override
	public void inserttopaid(Topaid topaid) {
		topaid.setStatus("租金未缴");
		topaidMapper.inserttopaid(topaid);
	}
	@Override
	public List<Topaid> findtopaid(QueryVo vo) {
		List<Topaid> list=topaidMapper.findtopaid(vo);
		return list;
	}
	@Override
	public Topaid findbyid(Integer id) {
		Topaid topaid=topaidMapper.findbyid(id);
		return topaid;
	}
	@Override
	public void gotopay(Integer id, Paid paid) {
		paidMapper.insertpaid(paid);
		topaidMapper.deletetopaid(id);
		
	}

}
