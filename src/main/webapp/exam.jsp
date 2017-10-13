<%--
  Created by IntelliJ IDEA.
  User: zlc
  Date: 17-7-26
  Time: 下午1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>正在测试</title>
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
                >> >> 决战沙场
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
<form action="${pageContext.request.contextPath}/examResultServlet" method="post">
    <table border="1" align="center">
        <caption>开始测试</caption>
        <th>题号</th>
        <th colspan="4">题目</th>
        <c:forEach items="${exam.list}" var="problem">
            <tr>
                <td rowspan="2">${problem.pid}</td>
                <td colspan="4">${problem.question}</td>
            </tr>
            <tr>
                <td>
                    <input type="radio" name="${problem.pid}" id="A" value="A">${problem.ansA}</input>
                </td>
                <td>
                    <input type="radio" name="${problem.pid}" id="B" value="B">${problem.ansB}</input>
                </td>
                <td>
                    <input type="radio" name="${problem.pid}" id="C" value="C">${problem.ansC}</input>
                </td>
                <td>
                    <input type="radio" name="${problem.pid}" id="D" value="D">${problem.ansD}</input>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<h6 align="center">${exam.note}</h6>
<form>
    <table align="center">
        <caption>测试结果</caption>
        <th hidden></th>
        <c:forEach items="${result.list}" var="problem">
            <tr>
                <td rowspan="2">${problem.eid}</td>
                <td colspan="4">${problem.reply}</td>
                <td colspan="4">${problem.answer}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3"><h5>${result.score}</h5></td>
        </tr>
        <tr>
            <td align="center" colspan="3">${result.note}</td>
        </tr>
    </table>
</form>
</body>
</html>
