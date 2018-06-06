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
	  <h2>&gt;&gt;员工资料维护</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search" name="form-search" action="SelectEmpListByConditionServlet" method="post">
        <tr>
          <th align=left>性别:</th>
          <td><select name="sex" id="select">
            <option value="男">男</option>
            <option value="女">女</option>
          </select></td>
          <td><div align="left">员工编号:</div></td>
          <td><input name="eid" type="text" class="inputTextNormal" id="textfield6" value="${eid }"/></td>
          <td align="left">员工姓名:</td>
          <td align="left"><input name="ename" type="text" class="inputTextNormal" id="textfield62" value="${ename }" /></td>
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
        	<li><a href="content/institution-createmp.html" title="新建员工" class="btnNormal">新增</a></li>
        </ul>
    </div>
    <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
            <th >员工编号</th>
            <th>员工名字</th>
            <th >员工性别</th>
            <th>员工生日</th>
            <th >雇佣日期</th>
            <th >联系电话</th>
            <th >职位</th>
            <th class="editColM">操作</th>
        </tr>
        <c:forEach items="${pageutil.list }" var="emp">
        <tr>
            <td align="center">${emp.eid }</td>
            <td align="center">${emp.ename }</td>
            <td align="center">${emp.sex }</td>
            <td align="center">${emp.sbirthday }</td>
            <td align="center">${emp.shireday }</td>
            <td align="center">${emp.phone }</td>
            <td align="center">${emp.job }</td>
            <td align="center">
            	<a href="institution-view.html" class="btnIconView" title="查看详情"></a>
            	<a href="ToUpdateEmpServlet?eid=${emp.eid }" class="btnIconEdit" title="更新"></a>
                <a href="DeleteEmpServlet?eid=${emp.eid }" class="btnIconDel" title="删除"></a>
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
