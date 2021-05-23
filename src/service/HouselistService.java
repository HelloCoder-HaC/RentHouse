package service;

import java.util.List;

import Pojo.Houselist;
public interface HouselistService {
	List<Houselist> selectAll();
	List<Houselist> selects(String price,String area,String status,String address);
	List<Houselist> selectLandladyAll(String username);
	Houselist findhouseid(String houseid);
	void inserthouse(Houselist houselist);
	void deletehouse(int id);
	Houselist findid(int id);
	Houselist findhouseidupdate(Houselist houselist);
	void updatehouse(Houselist houselist);
	void updatehousestatus(Houselist houselist);
	public void deletehousebyhouseid(String house_id);
}
