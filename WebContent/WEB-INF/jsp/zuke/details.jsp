<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>房屋租赁系统</title>
<link rel="stylesheet" type="text/css" href="/house/css/common.css" />
<link rel="stylesheet" type="text/css" href="/house/css/main.css" />
<script type="text/javascript" src="/house/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/house/js/libs/modernizr.min.js"></script>
<style type="text/css">
.img-span {
	float: left;
	margin: 20px 20px 20px 20px;
	width: 600px;
}
</style>
<script type="text/javascript">
	var error = "${param.error}";
	if (error == "applycheck") {

		alert("你还没完善个人信息，请完善个人信息后再进行申请操作");
	} else if (error == "applysuccess") {
		alert("申请成功，请耐心等待房东联系您！");
	}
</script>
</head>
<body>
	<div>
		<div class="result-title">
			<h1>房屋详情页</h1>
		</div>
		<div>
			<span class="img-span"> <img alt="${houseDetail.address}"
				src="${houseDetail.img}" width="600px" height="400px">
			</span>
			<span class="img-span"> <br>
				<p>房屋  I D: ${houseDetail.houseid }</p> <br>
				<p>房屋价格: ${houseDetail.price } 元</p> <br>
				<p>房屋面积: ${houseDetail.area } 平米</p> <br>
				<p>房屋状态: ${houseDetail.status }</p> <br>
				<p>房东姓名: ${houseDetail.landlady }</p> <br>
				<p>房屋地址: ${houseDetail.address }</p> <br>
				<p>房屋简介: ${houseDetail.introduce }</p>
			</span>
		</div>
		<div>
		<c:choose>
				<c:when test="${ houseDetail.status=='未租赁'}">
				<a class="link-update" href="applycheckuserlist.action?id=${houseDetail.id}"><button>申请看房</button></a>&nbsp;&nbsp; 
				</c:when>
				<c:when test="${ houseDetail.status=='已租赁'}">
					<button>该房已被租赁</button>&nbsp;&nbsp; 
				</c:when>
				<c:otherwise>
					 <button>该房已被申请</button>
				</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>