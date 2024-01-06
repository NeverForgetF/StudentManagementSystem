<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    /*获取项目的根路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" + request.getServerName()+":"+request.getServerPort()+path;
    /*basePath就是得到的跟路径类似于：http://localhost:8081/pinduoduo/*/
%>
<!doctype html public "-//w3c//dtd xhtml 1.0 frameset//en" "http://www.w3.org/tr/xhtml1/dtd/xhtml1-frameset.dtd">
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <meta http-equiv=pragma content=no-cache />
        <meta http-equiv=cache-control content=no-cache />
        <meta http-equiv=expires content=-1000 />
        
        <title>启明星辰人力资源管理V1.0</title>
    </head>
		<frameset cols="170, *">
                <frame name=left src="<%=basePath%>/view/left.jsp" frameborder=0 noresize />
                <frame name=right src="<%=basePath%>/view/right.jsp" frameborder=0 noresize scrolling=yes />
		</frameset>		
    <noframes>	
    </noframes>
</html>