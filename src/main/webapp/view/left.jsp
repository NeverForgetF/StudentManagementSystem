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
        <script language=javascript>
            function expand(el)
            {
                childobj = document.getElementById("child" + el);

                if (childobj.style.display == 'none')
                {
                    childobj.style.display = 'block';
                }
                else
                {
                    childobj.style.display = 'none';
                }
                return;
            }
        </script>
    </head>
    <body background=<%=basePath%>/img/menu_bg.jpg >
        <table height="100%" cellspacing=0 cellpadding=0 width=170   background=<%=basePath%>/img/menu_bg.jpg border=0>
            <tr>
                <td valign=top align=middle>
                    <table cellspacing=0 cellpadding=0 width="100%" border=0>
						<tr>
                            <td height=10></td>
						</tr>
					</table>
                   
             
					<table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=<%=basePath%>/img/menu_bt.jpg>
							   <a     class=menuparent onclick=expand(2)    href="javascript:void(0);">教务中心</a>
							 </td>
						</tr>
                        <tr height=4>
                            <td></td>
						</tr>
					</table>		
							
					<table id=child2 style="display: none" cellspacing=0 cellpadding=0  width=150 border=0>
                       
						<tr height=20>
                            <td align=middle width=30>
								<img height=9  src="<%=basePath%>/img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild href="<%=basePath%>/list?method=getAllStudent&page=1" target="right">学生管理</a>
							</td>
						</tr>
<%--                        &stuName=undefined&stuNo=undefined&sex=-1--%>
						
						
                      
                        <tr height=4>
                            <td colspan=2></td>
						</tr>
					</table>
					
					
									
				</td>
                <td width=1 bgcolor=#d1e6f7></td>
            </tr>
        </table>
    </body>
</html>