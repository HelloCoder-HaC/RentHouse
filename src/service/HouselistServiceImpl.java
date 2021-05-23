package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import Pojo.Houselist;
import dao.HouselistMapper;

@Service
public class HouselistServiceImpl implements HouselistService {
	
	@Autowired
	private HouselistMapper houselistMapper;
	
	@Override
	public List<Houselist> selectAll() {
		List<Houselist> houselist=houselistMapper.selectAll();
		return houselist;
	}
	
	@Override
	public List<Houselist> selects(String price,String area,String status,String address) {
		if(price==null || price==""){
			if(area==null || area==""){
				List<Houselist> houselist1=houselistMapper.selects1(status,address);
				return houselist1;
			}
			String[] areas = area.split(",");
			String area1 = areas[0];
			String area2 = areas[1];
			List<Houselist> houselist2=houselistMapper.selects2(area1,area2,status,address);
			return houselist2;
		}else {
			if(area==null || area==""){
				String[] prices = price.split(",");
				String price1 = prices[0];
				String price2 = prices[1];
				List<Houselist> houselist3=houselistMapper.selects3(price1,price2,status,address);
				return houselist3;
			}
		}
		
		String[] prices = price.split(",");
		String price1 = prices[0];
		String price2 = prices[1];
		String[] areas = area.split(",");
		String area1 = areas[0];
		String area2 = areas[1];
		//System.out.println("price1="+price1+" price2="+price2+" area1="+area1+" area2="+area2+" status="+status+" address="+address);
		List<Houselist> houselist=houselistMapper.selects(price1,price2,area1,area2,status,address);
		return houselist;
	}
	
	@Override
	public List<Houselist> selectLandladyAll(String username) {
		List<Houselist> houselist=houselistMapper.selectLandladyAll(username);
		return houselist;
	}

	@Override
	public Houselist findhouseid(String houseid) {
		Houselist houselist=houselistMapper.findhouseid(houseid);
		return houselist;
	}

	@Override
	public void inserthouse(Houselist houselist) {
		// TODO Auto-generated method stub
		houselistMapper.inserthouse(houselist);
	}

	@Override
	public void deletehouse(int id) {
		// TODO Auto-generated method stub
		houselistMapper.deletehouse(id);
	}

	@Override
	public Houselist findhouseidupdate(Houselist houselist) {
		Houselist list=houselistMapper.findhouseidupdate(houselist);
		return list;
	}

	@Override
	public void updatehouse(Houselist houselist) {
		houselistMapper.updatehouse(houselist);
		
	}

	@Override
	public Houselist findid(int id) {
		Houselist list=houselistMapper.findid(id);
		return list;
	}

	@Override
	public void updatehousestatus(Houselist houselist) {
		// TODO Auto-generated method stub
		houselistMapper.updatehousestatus(houselist);
	}

	@Override
	public void deletehousebyhouseid(String house_id) {
		houselistMapper.deletehousebyhouseid(house_id);
		
	}


}
