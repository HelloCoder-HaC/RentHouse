package Pojo;

import org.springframework.web.multipart.MultipartFile;

public class Houselist {
  private Integer id;//自动生成房屋id
  private String houseid;//房屋id
  private String address;//房屋地址
  private double area;//房屋面积
  private double price;//房屋价格
  private String status;//房屋状态
  private String img;//图片途径
  private String introduce;//房屋简介
  private String landlady;//房东姓名
  private MultipartFile file;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getHouseid() {
	return houseid;
}
public void setHouseid(String houseid) {
	this.houseid = houseid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
public String getIntroduce() {
	return introduce;
}
public void setIntroduce(String introduce) {
	this.introduce = introduce;
}
public String getLandlady() {
	return landlady;
}
public void setLandlady(String landlady) {
	this.landlady = landlady;
}
@Override
public String toString() {
	return "Houselist [id=" + id + ", houseid=" + houseid + ", address="
			+ address + ", area=" + area + ", price=" + price + ", status="
			+ status + ", img=" + img + ", introduce=" + introduce
			+ ", landlady=" + landlady + ", file=" + file + "]";
}
  
}
