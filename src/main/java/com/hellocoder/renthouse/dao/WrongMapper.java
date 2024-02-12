package com.hellocoder.renthouse.dao;

import java.util.List;

import com.hellocoder.renthouse.Pojo.QueryVo;
import com.hellocoder.renthouse.Pojo.Wrong;

public interface WrongMapper {
  public List<Wrong> findwrong(QueryVo vo);
  public Wrong findbyid(Integer id);
  public void insertwrong(Wrong wrong);
  public void deletewrong(Integer id);
}
