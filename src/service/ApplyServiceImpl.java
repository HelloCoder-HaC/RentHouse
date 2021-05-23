package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Pojo.Apply;
import Pojo.Houselist;
import dao.ApplyMapper;
import dao.HouselistMapper;
import dao.UserlistMapper;

@Service
@Transactional
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private ApplyMapper applyMapper;
	@Autowired
	private HouselistMapper houselistMapper;
	@Autowired
	private UserlistMapper userlistMapper;
	
	@Override
	public void insertapply(Apply apply) {
		applyMapper.insertapply(apply);
		
	}

	@Override
	public List<Apply> findapplylist() throws Exception{
		//String status = "申请中";
		List<Apply> apply=applyMapper.findapplylist();
		return  apply;
	}

	@Override
	public Apply findbyhouse_id(String house_id) {
		Apply apply=applyMapper.findbyhouse_id(house_id);
		return apply;
	}

	@Override
	public void deletebyhouse_id(String house_id) {
		applyMapper.deletebyhouse_id(house_id);
		
	}

	@Override
	public void refuseapply(Houselist houselist,String name) {
		houselistMapper.updatestatus(houselist);
		Apply apply = new Apply();
		apply.setStatus("已拒绝");
		apply.setHouse_id(houselist.getHouseid());
		applyMapper.updateapplystatus(apply);
		
		/*Houselist house= houselistMapper.findhouseid(houselist.getHouseid());
		Userlist userlist = userlistMapper.findhasuserlistbyname(name);
		Apply apply = new Apply();
		apply.setAddress(house.getAddress());
		apply.setArea(house.getArea());
		apply.setHouse_id(house.getHouseid());
		apply.setPrice(house.getPrice());
		apply.setStatus(house.getStatus());
		apply.setUserlist_id(userlist.getId());
		applyMapper.insertapply(apply);*/
	}

	@Override
	public List<Apply> findallapplyout() {
		List<Apply> list = applyMapper.findallapplyout();
		return list;
	}
	

}
