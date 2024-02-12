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
}

.page-div {
	float: right;
}
</style>
<script type="text/javascript">
	var error = "${param.error}";
	if (error == "applycheck") {

		alert("你还没完善个人信息，请完善个人信息后再进行申请操作");
	} else if (error == "applysuccess") {
		alert("申请成功，请耐心等待房东联系您！");
	}
	$(function(){
	$('#sub').click(function(){
		var price = $('#price').val();
		var area = $('#area').val();
		var status = $('#status').val();
		var address = $('#address').val();
		$(this).attr("href","selects.action?price="+price+"&area="+area+"&status="+status+"&address="+address);
		//location.href="selects.action?";
		//alert("price="+price+"&area="+area+"&status="+status+"&address="+address);
	})
	})
</script>
</head>
<body>
	<div>
		<div class="result-title">
			<h1>房源列表</h1>
		</div>
		<form id="houseForm" name="houseForm" action="houselist.action"
			method=post>
			<div class="result-title">
				<div class="result-list"></div>
			</div>
			<div class="result-content">
				<div>
					<div>
						&nbsp; &nbsp; &nbsp; &nbsp; 房屋价格:<select name="price" id="price" class="required">
							<option value="">全部</option>
							<option value="0,500">0-500</option>
							<option value="500,1000">500-1000</option>
							<option value="1000,2000">1000-2000</option>
							<option value="2000,4000">2000-4000</option>
							<option value="4000,10000">4000+</option>
						</select>
						 &nbsp; &nbsp; &nbsp; &nbsp; 房屋面积:<select name="area" id="area" class="required">
							<option value="">全部</option>
							<option value="0,10">0-10</option>
							<option value="10,20">10-20</option>
							<option value="20,30">20-30</option>
							<option value="30,50">30-50</option>
							<option value="50,100">50-100</option>
							<option value="100,1000">100+</option>
						</select> 
						<select name="status" id="status" class="required" style="display: none;">
							<option value="">全部</option>
							<option value="未租赁">未租赁</option>
							<option value="已租赁">已租赁</option>
						</select> 
						&nbsp; &nbsp; &nbsp; &nbsp;地铁线路:<select name="address" id="address" class="required">
							<option value="">全部</option>
							<option value="地铁1号线">地铁1号线</option>
							<option value="地铁2号线">地铁2号线</option>
							<option value="地铁3号线">地铁3号线</option>
							<option value="地铁4号线">地铁4号线</option>
							<option value="地铁5号线">地铁5号线</option>
							<option value="地铁6号线">地铁6号线</option>
							<option value="地铁7号线">地铁7号线</option>
							<option value="地铁8号线">地铁8号线</option>
							<option value="地铁9号线">地铁9号线</option>
							<option value="地铁10号线">地铁10号线</option>
						</select>	
						&nbsp; &nbsp; &nbsp; &nbsp;<a id="sub" href="#" class="btn btn-primary btn2">查询</a>
					</div>
					<c:forEach items="${houselist}" var="houselist">
						<span class="img-span"> <a href="houseDetails.action?id=${houselist.id }">
						 <img alt="${houselist.houseid}" src="${houselist.img}" width="350px" height="300px">
								<p>价格: ${houselist.price }</p>
								<p>面积: ${houselist.area }</p>
								<p>状态: ${houselist.status }</p>
						</a>
						</span>
					</c:forEach>
				</div>
			</div>
			<span id=pagelink>
				<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">
					共[<B>${p.total}</B>]条记录，共[<B>${p.pages}</B>]页 ,
					<c:if test="${ p.pageNum > 1 }">
													[<A href="javascript:to_page(${p.prePage})">前一页</A>]
												</c:if>
					<input type="hidden" name="page" id="page" value="" /> 第<B>${p.pageNum}</B>页

					<c:if test="${ p.pageNum < p.pages }">
													[<A href="javascript:to_page(${p.nextPage})">后一页</A>] 
												</c:if>
				</div>
			</span>
		</form>
	</div>
	<script language=javascript>
		// 提交分页的查询的表单
		function to_page(page) {
			if (page) {
				$("#page").val(page);
			}
			document.houseForm.submit();
		}
	</script>
</body>
</html>