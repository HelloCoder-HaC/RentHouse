<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/house/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/house/css/main.css"/>
    <script type="text/javascript" src="/house/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/house/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/house/js/jquery.validate.min.js"></script>
   <style>
.error {
  font-size:13px;
  color: red;
}
   </style>
    <script type="text/javascript">
    $().ready(function() {
    	
    	$(".mr10").click(function(){
    		var idcard = $('#idcard').val();
    		var flag = checkIDCard(idcard);
    		if(!flag){
    			window.confirm("身份证不合法!");
    			return false;
    		}
    	})
    		
    	
        // 在键盘按下并释放及提交后验证提交表单
        $("#myform").validate({
            rules : {
            	name : {
            		rangelength:[2,8],
                    required : true,
                },
                idcard : {
                    rangelength:[18,18],
                    required : true,
                },
                phone : {
                	number: true,
                	rangelength:[11,11],
                    required : true,
                }
            },
            messages : {
            	name : {
            		rangelength:"姓名长度必须在2-8个字之间！",
                    required : "姓名不能为空！",
                },
                idcard : {
                	rangelength:"请输入18位身份证号码！",
                    required : "身份证号码不能为空！",
                },
                phone : {
                    number: "请输入11位手机号码",
                    rangelength:"手机号不合法！",
                    required : "手机号码不能为空！",
                }
            }
        });
    })
    
    // 函数参数必须是字符串，因为二代身份证号码是十八位，而在javascript中，十八位的数值会超出计算范围，造成不精确的结果，导致最后两位和计算的值不一致，从而该函数出现错误。
// 详情查看javascript的数值范围
function checkIDCard(idcode){
    // 加权因子
    var weight_factor = [7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];
    // 校验码
    var check_code = ['1', '0', 'X' , '9', '8', '7', '6', '5', '4', '3', '2'];

    var code = idcode + "";
    var last = idcode[17];//最后一个

    var seventeen = code.substring(0,17);

    // ISO 7064:1983.MOD 11-2
    // 判断最后一位校验码是否正确
    var arr = seventeen.split("");
    var len = arr.length;
    var num = 0;
    for(var i = 0; i < len; i++){
        num = num + arr[i] * weight_factor[i];
    }
    
    // 获取余数
    var resisue = num%11;
    var last_no = check_code[resisue];

    // 格式的正则
    // 正则思路
    /*
    第一位不可能是0
    第二位到第六位可以是0-9
    第七位到第十位是年份，所以七八位为19或者20
    十一位和十二位是月份，这两位是01-12之间的数值
    十三位和十四位是日期，是从01-31之间的数值
    十五，十六，十七都是数字0-9
    十八位可能是数字0-9，也可能是X
    */
    var idcard_patter = /^[1-9][0-9]{5}([1][9][0-9]{2}|[2][0][0|1][0-9])([0][1-9]|[1][0|1|2])([0][1-9]|[1|2][0-9]|[3][0|1])[0-9]{3}([0-9]|[X])$/;

    // 判断格式是否正确
    var format = idcard_patter.test(idcode);

    // 返回验证结果，校验码和格式同时正确才算是合法的身份证号码
    return last === last_no && format ? true : false;
}
    
	</script>
</head>
<body>

<div class="result-title">
<h1>完善个人资料</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="checkuserlist.action" method="post" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        	<tr><th><input type="hidden" name="id" value="${userlist.id}"/></th></tr>
                        	<tr>
                                <th><i class="require-red">*</i>真实姓名：</th>
                                <td>
                                <c:if test="${empty userlist.name}">
                                	<input class="common-text required" value="${userlist.name}" id="name" name="name" size="50" type="text">
                                </c:if>
                                <c:if test="${not empty userlist.name}">
                                	<input class="common-text required" value="${userlist.name}" id="name" name="name" size="50" type="text" readonly="readonly">
                                </c:if>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>身份证号码：</th>
                                <td>
                                <c:if test="${empty userlist.idcard }">
                                	<input class="common-text" name="idcard" value="${userlist.idcard }" id="idcard" size="50" type="text">
                                </c:if>
                                <c:if test="${not empty userlist.idcard }">
                                	<input class="common-text" name="idcard" value="${userlist.idcard }" id="idcard" size="50" type="text" readonly="readonly">
                                </c:if>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>手机号码：</th>
                                <td><input class="common-text" name="phone" value="${userlist.phone }" id="phone" size="50" type="text" ></td>
                            </tr>
                           
								<tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
							<tr>
                                <td><font id="error" color="red">${error }</font></td>
                            </tr>	
                        </table>
                </form>
          </div>
          </div>
</body>
</html>