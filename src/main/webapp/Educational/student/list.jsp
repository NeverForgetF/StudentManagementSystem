<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    /*获取项目的根路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    /*basePath就是得到的跟路径类似于：http://localhost:8081/pinduoduo/*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>学生信息管理平台</title>
    <link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css"/>
    <link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css"/>
    <link href="../../Style/ks.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js"
            type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js"
            type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>

    <script type="">
        function del() {
            confirm("确认操作？");
        }
    </script>
</head>
<body>
<div class="div_head" style="width: 100%;text-align:center;">
		<span>
            <span style="float: left;">当前位置是：教务中心-》学生管理</span>
            <span style="float: right; margin-right: 8px; font-weight: bold;">
                <a style="text-decoration: none;" href="<%=basePath%>/grade?means=add">【新增学生】</a>&emsp;&emsp;&emsp;&emsp;
            </span>
        </span>
</div>

<div class="cztable">
    <div>
        <form action="<%=basePath%>/list?method=getAllStudent&page=1" method="post">
            学生名称:
            <input type="text" name="stuName" value="${requestScope.stuName}"/>
            学生学号:
            <input type="text" name="stuNo" value="${requestScope.flag!="true"?requestScope.stuNo:""}"/>
            性别:
            <select name="sex">
                <option value="0" ${(requestScope.sex!=("1"&&"2"))||(requestScope.falg=="true")?"selected":""}>--请选择--</option>
                <option value="1" ${(requestScope.sex==1)&&(requestScope.flag!="true")?"selected":""}>男</option>
                <option value="2" ${(requestScope.sex==2)&&(requestScope.flag!="true")?"selected":""}>女</option>
            </select>
            <input type="submit" value="查询"/>

        </form>


        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr style="height: 25px" align="center">
                <th>学号</th>
                <th width="">姓名</th>
                <th width="">性别</th>
                <th width="15%">联系电话</th>
                <th width="15%">专业</th>
                <th width="15%">登记时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.studentList}" var="student">
                <tr id="product1">
                    <td align="center">${student.stuNo}</td>
                    <td align="center">${student.stuName}</td>
                    <td align="center">${(student.sex)==1?"男":"女"}</td>
                    <td align="center">${student.phone}</td>
                    <td align="center">${student.profession}</td>
                    <td align="center">${student.regDate}</td>
                    <td align="center">
                        <a href="<%=basePath%>/grade?means=alter&stuId=${student.stuId}">修改</a>
                        <a href="<%=basePath%>/list?method=delStudent&stuId=${student.stuId}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="20" style="text-align: center;">
					<a style="text-decoration: none;" href="<%=basePath%>/list?method=getAllStudent&page=1&
					stuName=${requestScope.stuName}&stuNo=${requestScope.stuNo}&sex=${requestScope.sex}">首页</a>
					<a style="text-decoration: none;" href="<%=basePath%>/list?method=getAllStudent&
					page=${(requestScope.page<2)?1:requestScope.page-1}&stuName=${requestScope.stuName}&
					stuNo=${requestScope.stuNo}&sex=${requestScope.sex}">上一页</a>
					<a style="text-decoration: none;" href="<%=basePath%>/list?method=getAllStudent&
					page=${(requestScope.page>=requestScope.allPage)?requestScope.allPage:requestScope.page+1}
					&stuName=${requestScope.stuName}&stuNo=${requestScope.stuNo}&sex=${requestScope.sex}">下一页</a>
					<a style="text-decoration: none;" href="<%=basePath%>/list?method=getAllStudent&page=${requestScope.allPage}
					&stuName=${requestScope.stuName}&stuNo=${requestScope.stuNo}&sex=${requestScope.sex}">末页</a>
					<a style="text-decoration: none;" href="<%=basePath%>/list?method=getAllStudent&page=${requestScope.allPage}
					&stuName=${requestScope.stuName}&stuNo=${requestScope.stuNo}&sex=${requestScope.sex}">共${requestScope.allPage}条</a>
                    <span>${requestScope.page}/${requestScope.allPage}</span>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
