<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>环球连锁手机管理系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>
  
<body class="content-pages-body">
<div class="content-pages-wrap">
    <div class="commonTitle"><h2>&gt;&gt; <a href="institution-list.html">员工资料维护</a> - 更新员工资料</h2></div>
     <form id="institutionCreat" name="institutionCreat" action="/hqls/UpdateEmpServlet" method="post">
     <input type="hidden" name="carid" value="${car.carid }"/>
    <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
         <td align="right"><span class="required">*</span>员工编号:</td>
            <td align="left"><input name="eid" type="text" readonly="true" class="inputTextMiddle" id="textfield" value="${emp.eid}"/></td>
        </tr>
        <tr>
         <td align="right"><span class="required">*</span>员工名称:</td>
            <td align="left"><input name="ename" type="text" class="inputTextMiddle" id="textfield" value="${emp.ename}"/></td>
             <td align="right"><span class="required">*</span>出生日期:</td>
            <td align="left" colspan="3"><input name="birthday" type="text" class="inputTextMiddle" id="textfield" value="${emp.sbirthday}"/></td>
        </tr>
        <tr>
            <td align="right"><span class="required">*</span>雇佣日期:</td>
            <td align="left"><input name="hireday" type="text" class="inputTextMiddle" id="textfield2" value="${emp.shireday}"/></td>
            <td align="right"><span class="required">*</span>性别:</td>
            <td align="left" colspan="4">
            	<input type="radio" name="sex" id="radio5" value="男"  <c:if test="${emp.sex=='男' }">checked="checked"</c:if> />男
                <input type="radio" name="sex" id="radio6" value="女" <c:if test="${emp.sex=='女' }">checked="checked"</c:if>/>女
            </td>
        </tr>
        <tr>
            <td align="right">联系电话:</td>
            <td colspan="3" align="left"><input name="phone" type="text" class="inputTextLong" id="textfield5" value="${emp.phone}"/></td>
            <td align="right">职位:</td>
            <td align="left"><input name="job" type="text" class="inputTextNormal" id="textfield4" value="${emp.job}"/></td>
        </tr>
       <!--  <tr>
       	     <td align="right"><span class="required">*</span>价格：</td>
            <td align="left"><input name="price" type="text" class="inputTextNormal" id="textfield6" value="${car.price}"/></td>
            <td align="right">图片：</td>
            <td align="left"><input name="imgurl" type="file" class="inputTextNormal" id="textfield6" value="${car.imgurl}"/></td>
          
        </tr>
        -->
       
    </table>
  
    <div id="formPageButton">
    	<ul>
        	<li><input type="submit" value="提交"/></li>
        </ul>
    </div>
   </form>
</div>
<!--//content pages wrap-->
</body>
</html>
