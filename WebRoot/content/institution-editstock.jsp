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
    <div class="commonTitle"><h2>&gt;&gt; <a href="institution-list.html">采购订单</a> - 更新采购订单</h2></div>
     <form id="institutionCreat" name="institutionCreat" action="/hqls/UpdateStockServlet" method="post">
     <input type="hidden" name="carid" value="${car.carid }"/>
    <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
         <td align="right"><span class="required">*</span>采购订单编号:</td>
            <td align="left"><input name="stid" type="text" readonly="true" class="inputTextMiddle" id="textfield" value="${stock.stid}"/></td>
        </tr>
        <tr>
         <td align="right"><span class="required">*</span>商品编号:</td>
            <td align="left"><input name="pid" type="text" class="inputTextMiddle" id="textfield" value="${stock.pid}"/></td>
             <td align="right"><span class="required">*</span>颜色编号:</td>
            <td align="left" colspan="3"><input name="cid" type="text" class="inputTextMiddle" id="textfield" value="${stock.cid}"/></td>
        </tr>
        <tr>
            <td align="right"><span class="required">*</span>内存编号:</td>
            <td align="left"><input name="mid" type="text" class="inputTextMiddle" id="textfield2" value="${stock.mid}"/></td>
        </tr>
        <tr>
            <td align="right">采购数量:</td>
            <td colspan="3" align="left"><input name="count" type="text" class="inputTextLong" id="textfield5" value="${stock.count}"/></td>
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
