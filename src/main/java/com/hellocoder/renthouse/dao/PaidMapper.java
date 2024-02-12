package com.hellocoder.renthouse.dao;

import java.util.List;

import com.hellocoder.renthouse.Pojo.Paid;
import com.hellocoder.renthouse.Pojo.QueryVo;

public interface PaidMapper {
public List<Paid> selectall(QueryVo vo);
public Double selectsum(QueryVo vo);
public void deletepaid(Integer id);
public void insertpaid(Paid paid);
}
