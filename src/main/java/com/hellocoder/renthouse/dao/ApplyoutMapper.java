package com.hellocoder.renthouse.dao;

import com.hellocoder.renthouse.Pojo.Applyout;

public interface ApplyoutMapper {
	public void insertapplyout(Applyout applyout);
	public void updateapplyout(Applyout applyout);
	public void updateapplyoutbyhouse(Applyout applyout);
	public Applyout findbyid(Integer id);
	public void deleteapplyout(Integer id);
}
