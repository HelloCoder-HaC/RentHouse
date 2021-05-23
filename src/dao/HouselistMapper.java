package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Pojo.Houselist;
import Pojo.QueryVo;

public interface HouselistMapper {
List<Houselist> selectAll();
List<Houselist> selects1(@Param("status")String status,@Param("address")String address);
List<Houselist> selects2(@Param("area")String area,@Param("area2")String area2,@Param("status")String status,@Param("address")String address);
List<Houselist> selects3(@Param("price")String price,@Param("price2")String price2,@Param("status")String status,@Param("address")String address);

List<Houselist> selects(@Param("price")String price,@Param("price2")String price2,@Param("area")String area,@Param("area2")String area2,@Param("status")String status,@Param("address")String address);
List<Houselist> selectLandladyAll(String username);
public Integer findhouselistByVoCount(QueryVo vo);
Houselist findhouseid(String houseid);
void inserthouse(Houselist houselist);
void deletehouse(int id);
Houselist findid(int id);
Houselist findhouseidupdate(Houselist houselist);
void updatehouse(Houselist houselist);
void updatehousestatus(Houselist houselist);
public void deletehousebyhouseid(String house_id);
public void updatestatus(Houselist houselist);
}
