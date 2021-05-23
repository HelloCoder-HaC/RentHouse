package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import Pojo.Houselist;
import Pojo.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import service.HouselistService;
@Controller
public class HoustlistController {
	@Autowired
	private HouselistService houselistService;
	
	@RequestMapping("/houselist")
	public String houselist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="6") Integer pageSize){
		 PageHelper.startPage(page, pageSize);
		List<Houselist> houselist=houselistService.selectAll();
	PageInfo<Houselist> p=new PageInfo<Houselist>(houselist);
		model.addAttribute("p", p);
		model.addAttribute("houselist",houselist);
		model.addAttribute("mainPage","houselist.jsp");
		return "zuke/main";
	}
	
	@RequestMapping("/selects")
	public String selects(Model model ,@RequestParam(required=false,defaultValue="1") Integer page, 
			@RequestParam(required=false,defaultValue="6") Integer pageSize,@RequestParam(value="price")String price,
			@RequestParam(value="area")String area,@RequestParam(value="status")String status,@RequestParam(value="address")String address){
		 PageHelper.startPage(page, pageSize);
		List<Houselist> houselist=houselistService.selects(price,area,status,address);
	PageInfo<Houselist> p=new PageInfo<Houselist>(houselist);
		model.addAttribute("p", p);
		model.addAttribute("houselist",houselist);
		model.addAttribute("mainPage","houselist.jsp");
		return "zuke/main";
	}
	
	@RequestMapping("/ahouselist")
	public String ahouselist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="6") Integer pageSize,HttpServletRequest request){
		User username = (User) request.getSession().getAttribute("user");
		 PageHelper.startPage(page, pageSize);
		List<Houselist> houselist=houselistService.selectLandladyAll(username.getUsername());
	PageInfo<Houselist> p=new PageInfo<Houselist>(houselist);
		
				
		model.addAttribute("p", p);
		model.addAttribute("houselist",houselist);
		model.addAttribute("mainPage","ahouselist.jsp");
		return "admin/main1";
	}
	
	@RequestMapping("/addhouse")
	public String addhouse(Model model ,Houselist houselist,HttpServletRequest request) throws IllegalStateException, IOException{
		//System.out.println("houseid===="+request.getParameter("houseid"));



		String houseid=houselist.getHouseid();
		Houselist houselist1=houselistService.findhouseid(houseid);
		if(houselist1!=null){
			model.addAttribute("error","该房屋id已存在");
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage","addhouse.jsp");
			return "admin/main1";
		}else{
			model.addAttribute("error","添加成功");
			//System.out.println("houseid===="+request.getParameter("houseid"));
			//保存数据库的路径
			String sqlPath = null;
			//定义文件保存的本地路径
			String localPath="D:\\imgs\\";
//			String localPath =request.getRealPath("\\imgs")+"\\";
			// 定义 文件名
			String filename=null;
			
			if(!houselist.getFile().isEmpty()){
			//生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType=houselist.getFile().getContentType();
			//获得文件后缀名
			String suffixName=contentType.substring(contentType.indexOf("/")+1);
			//得到 文件名
			filename=uuid+"."+suffixName;
			//System.out.println(filename);
			//文件保存路径
			houselist.getFile().transferTo(new File(localPath+filename));
			}
			//把图片的相对路径保存至数据库
			sqlPath = "imgs/"+filename;
			//user.setId(1);
			User username = (User) request.getSession().getAttribute("user");
			houselist.setHouseid(request.getParameter("houseid"));
			houselist.setAddress(request.getParameter("address"));
			houselist.setArea(Integer.parseInt(request.getParameter("area")));
			houselist.setPrice(Integer.parseInt(request.getParameter("price")));
			houselist.setIntroduce(request.getParameter("introduce"));
			houselist.setLandlady(username.getUsername());
			houselist.setImg(sqlPath);
			houselist.setStatus(request.getParameter("status"));
			houselistService.inserthouse(houselist);
			model.addAttribute("houselist", houselist);
			model.addAttribute("mainPage","addhouse.jsp");
			return "admin/main1";
			}
	}
	
	@RequestMapping("/toaddhouse")
	public String toaddhoust(Model model){
		model.addAttribute("mainPage","addhouse.jsp");
		return "admin/main1";
	}
	@RequestMapping("/deletehouse")
	public String deletehouse(Integer id){
		houselistService.deletehouse(id);
		return "redirect:ahouselist.action";
	}
	@RequestMapping("/toahouselist")
	public String toahouselist(){
		return "ahouselist.action";
	}
	@RequestMapping("/findid")
	public String findid(Integer id,Model model){
		Houselist list=houselistService.findid(id);
		model.addAttribute("houselist",list);
		model.addAttribute("mainPage", "changehouse.jsp");
		return "admin/main1";
	}
	@RequestMapping("/findhouseidupdate")
	public String findhouseidupdate(Houselist houselist,Model model){
		Houselist list=houselistService.findhouseidupdate(houselist);
		if(list!=null){
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage", "changehouse.jsp");
			model.addAttribute("error","该房屋id已存在");
			return "admin/main1";
		}
		else{
			houselistService.updatehouse(houselist);
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage", "changehouse.jsp");
			model.addAttribute("error","更新成功");
			return "admin/main1";
		}
	}
	
	@RequestMapping("/houseDetails")
	public String houseDetails(Integer id,Model model){
		Houselist houseDetail=houselistService.findid(id);
		model.addAttribute("houseDetail",houseDetail);
		model.addAttribute("mainPage", "details.jsp");
		return "zuke/main"; 
	}
	
	@RequestMapping("/changeHouseList")
	public String changeHouseList(Houselist houselist,Model model){
		//System.out.println("传递过来的表单数据为："+houselist.toString());
		model.addAttribute("mainPage", "details.jsp");
		return "zuke/main"; 
	}
	
}
