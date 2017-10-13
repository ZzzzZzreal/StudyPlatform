<%--
  Created by IntelliJ IDEA.
  User: yrq
  Date: 17-7-20
  Time: 下午7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>个人中心</title>
</head>
<body style="padding:0;margin-top: 1%; margin-left:25%; margin-right: 25%;">
<script>
    function getDateDemo() {
        /*
         //声明时间
         var date = new Date();
         alert(date);//当前时间
         alert(date.toLocaleString());//转化为本地时间
         alert(date.getFullYear());//显示年份
         alert(date.getMonth() + 1);//显示月份 0-11，需要加1
         alert(date.getDate());//显示一月中的日期
         alert(date.getDay());//显示一周的日期，星期几
         alert(date.getHours());//获取小时时间
         alert(date.getMinutes());//获取当前分钟
         alert(date.getSeconds());//获取当前秒数
         alert(date.getMilliseconds());//获取当前的毫秒数
         alert(date.getTime());//获取从1970年1月1日午夜零时，到当前时间的毫秒值
         */
//分别获取年、月、日、时、分、秒
        var myDate = new Date();
        var year = myDate.getFullYear();
        var month = myDate.getMonth() + 1;
        var date = myDate.getDate();
        var hours = myDate.getHours();
        var minutes = myDate.getMinutes();
        var seconds = myDate.getSeconds();
//月份的显示为两位数字如09月
        if (month < 10) {
            month = "0" + month;
        }
        if (date < 10) {
            date = "0" + date;
        }
//时间拼接
        var dateTime = year + "年" + month + "月" + date + "日   " + hours + ":" + minutes + ":" + seconds + "    ";
//document.write(dateTime);//打印当前时间
        var divNode = document.getElementById("time");
        divNode.innerHTML = dateTime;
    }
    window.setInterval("getDateDemo()", 1000);//每隔1秒，调用一次getDateDemo()
</script>
<%-- ======================================================================================================================== --%>
<form>
    <table border="1" align="left">
        <tr>
            <td>
                <div id="time"></div>
            </td>
        </tr>
    </table>
    <table border="1" align="right" cellspacing="10">
        <tr>
            <td>${uname}</td>
            <td>
                <a href="${pageContext.request.contextPath}/regist.jsp">&nbsp;&nbsp;注&nbsp;册&nbsp;&nbsp;</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/login.jsp">&nbsp;&nbsp;登&nbsp;录&nbsp;&nbsp;</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/exit">&nbsp;&nbsp;注&nbsp;销&nbsp;&nbsp;</a>
            </td>
        </tr>
    </table>
</form>
<br/><br/><br/>
<form>
    <table border="1" align="center" cellspacing="20">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/index.jsp">&nbsp;&nbsp;&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/studyArea.jsp">&nbsp;&nbsp;学&nbsp;习&nbsp;园&nbsp;地&nbsp;&nbsp;</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/index.jsp">&nbsp;&nbsp;敬&nbsp;请&nbsp;期&nbsp;待&nbsp;&nbsp;</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/userCenterimg">&nbsp;&nbsp;个&nbsp;人&nbsp;中&nbsp;心&nbsp;&nbsp;</a>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                >> >> 个人中心
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
<%
    String cid=request.getParameter("cid");
   /* System.out.println(cid);*/
    System.out.println("5555555");
%>
<form name="f1" action="${pageContext.request.contextPath}/evalute" method="post" <%--enctype="multipart/form-data"--%>
      onSubmit="return check();">
    <table align="center" border="1">
        <tr><td  align="center" colspan="2">课程评价</td></tr>
        <input type="hidden" name="cid" value="<%=cid%>">
        <tr>
            <td>评价</td>
            <td><textarea name="evalute" id="" cols="30" rows="10"></textarea></td>
        </tr>
        <tr  >
            <td align="center" colspan="2" >
                <input class="btn btn-default" type="submit" id="btnSubmit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

