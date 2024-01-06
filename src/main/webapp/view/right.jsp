<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    /*获取项目的根路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" + request.getServerName()+":"+request.getServerPort()+path;
    /*basePath就是得到的跟路径类似于：http://localhost:8081/pinduoduo/*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <link href="<%=basePath%>/css/admin.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <table cellspacing=0 cellpadding=0 width="100%" align=center border=0>
            <tr height=28>
                <td background=<%=basePath%>/img/title_bg1.jpg>当前位置: </td></tr>
            <tr>
                <td bgcolor=#b1ceef height=1></td></tr>
            <tr height=20>
                <td background=<%=basePath%>/img/shadow_bg.jpg></td></tr></table>
        <table cellspacing=0 cellpadding=0 width="90%" align=center border=0>
            <tr height=100>
                <td align=middle width=100>
					<img height=100 src="<%=basePath%>/img/admin_p.gif"  width=90>
				</td>
                <td width=60>&nbsp;</td>
                <td>
                    <table height=100 cellspacing=0 cellpadding=0 width="100%" border=0>

                        <tr>
                         <td>当前时间：2018-12-27 17:03:55</td>
						</tr>
                        <tr>
                            <td style="font-weight: bold; font-size: 16px">${sessionScope.user.realName}</td>
						</tr>
                        <tr>
                            <td>欢迎进入网站管理中心！</td></tr></table></td>
						</tr>
            <tr>
         <td colspan=3 height=10></td></tr></table>
       
    </body>
</html>