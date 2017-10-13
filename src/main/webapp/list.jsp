<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 17-7-25
  Time: 下午8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/listServlet" method="post">

    <input type="hidden" name="major" id="major" value="${major}"/>

    <select type="option" name="genre" id="genre">

        <option selected="selected" value="0">所有课程</option>
        <option  value="java">java</option>
        <option  value="linux">linux</option>
    </select>
    <input type="submit" value="提交"/>



</form>
<table>

    <tr>
        <th>名称</th>
        <th>上传时间</th>
        <th>时长</th>
        <th>文件大小</th>

    </tr>
<c:forEach items="${list}" var="l">
    <tr >

        <td>
            <a href="${pageContext.request.contextPath}/details?r_id=${l.r_id}">${l.r_name}</a>
        </td>
        <td>${l.r_uptime}</td>
        <td>${l.duration}</td>
        <td>${l.filesize}</td>

    </tr>
</c:forEach>

</table>

</body>
</html>
