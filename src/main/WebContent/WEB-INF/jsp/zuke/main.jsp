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
<style>
.a:hover {
	cursor: pointer;
}
</style>
<script language=javascript>

	$().ready(function(){
		
		$('#fangyuan').click(function(){
			$('#afangyuan').slideToggle("slow");
		});
		$('#zulin').click(function(){
			$('#azulin').slideToggle("slow");
		});
		$('#sq').click(function(){
			$('#asq').slideToggle("slow");
		});
		$('#xinxi').click(function(){
			$('#axinxi').slideToggle("slow");
		});
		$('#baoz').click(function(){
			$('#abaoz').slideToggle("slow");
		});
		$('#qita').click(function(){
			$('#aqita').slideToggle("slow");
		});
		$('#caidan').click(function(){
			$('#acaidan').slideToggle("slow");
		});
		
		$('.ziliao').mousedown(function(){
			$.ajax({url:"/house/checkuserlists.action",success:function(date){
				if(date=='yes'){
					return true;
				}else{
					alert("请先完善资料再访问本资源");
					return false;
				}
				
			}});
		});
	})

	// 提交分页的查询的表单
	function to_page(url1) {

		$.ajax({
			url : url1,
			type : "post",
			async : false,

			success : function(data) {
				// 你的具体操作
				// alert(data);
				$("#inside").html(data);
				alert("成功");

			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	}
</script>
</head>
<body style="background: url('imgs/背景图.png');">
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="index.html" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on sendRequest" href="javascript::void(0)">首页</a></li>

				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li>欢迎您，${sessionScope.user.username}！</li>

					<li><a
						href="javascript:if(confirm('确实要退出登录吗?'))location='/house/login.action'">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1 id="caidan">菜单</h1>
			</div>
				<div style="display: none;" id="hide">${info }</div>
			<c:if test="${not empty info }">
				<div style="display: none;" id="hide">${info }</div>
			</c:if>
			<div class="sidebar-content" id="acaidan">
				<ul class="sidebar-list">
					<li><a class="a" id="fangyuan">房源信息</a>
						<div class="p" id="afangyuan">
							<ul class="sub-menu">
								<li><a href="/house/houselist.action">房源列表</a></li>
							</ul>
						</div></li>
					<li><a class="a" id="zulin">租赁信息</a>
						<div class="p" id="azulin">
							<ul class="sub-menu">
								<li><a href="/house/zulist/myzulist.action" class="ziliao">我的租赁</a></li>
								<li><a href="/house/checkout/getmycheckout.action" class="ziliao">已退租列表</a></li>
							</ul>
						</div></li>
					<li><a class="a" id="sq">我的申请</a>
						<div class="p" id="asq">
							<ul class="sub-menu">
								<li><a href="/house/getmyapply.action" class="ziliao">看房申请列表</a></li>
								<li><a href="/house/applyout/getmyapplyout.action" class="ziliao">退租申请列表</a></li>
							</ul>
						</div></li>
					<li><a class="a" id="xinxi">租金信息</a>
						<div class="p" id="axinxi">
							<ul class="sub-menu">
								<li><a href="/house/paid/mytopaidlist.action" class="ziliao">待缴租金</a></li>
								<li><a href="/house/paid/findmypaid.action" class="ziliao">已缴租金</a></li>
							</ul>
						</div></li>
					<li><a class="a" id="baoz">报障模块</a>
						<div class="p" id="abaoz">
							<ul class="sub-menu">
								<li><a href="/house/wrong/addwrong.action" class="ziliao">我要报障</a></li>
								<li><a href="/house/wrong/mywronglist.action" class="ziliao">未处理报障</a></li>
								<li><a href="/house/wrong/findmysolve.action" class="ziliao">已处理报障</a></li>
							</ul>
						</div></li>
					<li><a class="a" id="qita">其他操作</a>
						<div class="p" id="aqita">
							<ul class="sub-menu">
								<li><a href="/house/findhasuserlist.action">账户绑定</a></li>
							</ul>
						</div></li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>欢迎使用本网站！</span>
				</div>
			</div>
			<div class="result-wrap" id="inside">
				<jsp:include page="${mainPage==null?'../admin/index.jsp':mainPage}"></jsp:include>
			</div>
		</div>
	</div>
	<!--/main-->
	</div>
</body>
</html>