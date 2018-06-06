<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>环球连锁手机管理系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt;客户资料维护</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search" name="form-search" action="SelectCustomerListByConditionServlet" method="post">
        <tr>
          <th align=left>商品编号:</th>
          <td><input name="pid" type="text" class="inputTextNormal" id="textfield5" value="${pid }"/></td>
          <td><div align="left">客户编号:</div></td>
          <td><input name="cusid" type="text" class="inputTextNormal" id="textfield6" value="${cusid }"/></td>
          <td align="left">客户姓名:</td>
          <td align="left"><input name="cusname" type="text" class="inputTextNormal" id="textfield62" value="${cusname }"/></td>
          <td><input type="submit" value="检索"/></td>
        </tr>
       <!-- 
        <tr>
            <th align="right">行政区划：</th>
            <td><input name="textfield63" type="text" class="inputTextNormal" id="textfield63" value="用地址进行后台匹配" /></td>
            <td><div align="right">报告单位：</div></td>
            <td><input name="textfield64" type="text" class="inputTextNormal" id="textfield64" /></td>
            <td align="right">报告人：</td>
            <td align="right"><input name="textfield642" type="text" class="inputTextNormal" id="textfield642" /></td>
            <td align="right">&nbsp;</td>
            <td align="right"><button>检索</button></td>
        </tr>
       -->
        
       	</form>
    </table>
    <!--//commonTableSearch-->
    <div class="btnBar">
    	<ul class="clearfix">
        	<li><a href="content/institution-createmp.html" title="新建客户" class="btnNormal">新增</a></li>
        </ul>
    </div>
    <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
            <th >客户编号</th>
            <th>客户名字</th>
            <th >联系方式</th>
            <th >商品ID</th>
            <th >购买时间</th>
            <th >信息描述</th>
            <th class="editColM">操作</th>
        </tr>
        <c:forEach items="${pageutil.list }" var="cus">
        <tr>
            <td align="center">${cus.cusid }</td>
            <td align="center">${cus.cusname }</td>
            <td align="center">${cus.cusphone }</td>
            <td align="center">${cus.pid }</td>
            <td align="center">${cus.scustime }</td>
            <td align="center">${cus.descr }</td>
            <td align="center">
            	<a href="institution-view.html" class="btnIconView" title="查看详情"></a>
            	<a href="ToUpdateCustomerServlet?cusid=${cus.cusid }" class="btnIconEdit" title="更新"></a>
                <a href="DeleteCustomerServlet?cusid=${cus.cusid }" class="btnIconDel" title="删除"></a>
                 </td>
       </tr>
       </c:forEach>
    </table>
    <!--//commonTable-->
    <div id="pagelist">
    ${pageutil.str }
   	<!-- <ul class="clearfix">
        	<li><a href="#">首页</a></li>
            <li><a href="#">上页</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li class="current">3</li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">下页</a></li>
            <li><a href="#">尾页</a></li>
            <li class="pageinfo">第3页</li>
            <li class="pageinfo">共8页</li>
        </ul> -->
    </div>
</div>
<!--//content pages wrap-->
</body>
</html>
