<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<html>
<head>
    <title>HOMEPAGE</title>
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
<br/>
<br/><br/><br/>
<form action="${pageContext.request.contextPath}/search" method="post">
    <table border="1" align="right" cellspacing="10">
        <tr>
            <td>
            <select name="course">
            <option value="大数据">大数据</option>
            <option value="云计算">云计算</option>
            </select>
            <input type="text" name="searching" />
            <input type="submit" value="搜索"/>
            </td>
        </tr>
    </table>
</form>
<br/><br/><br/>

<form>
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
                >> >> 学习园地
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
<form>

    <h3>资源区</h3><br/>
    <a href="${pageContext.request.contextPath}/listServlet?major=0&genre=0">云计算</a><br/>
    <a href="${pageContext.request.contextPath}/listServlet?major=大数据&genre=0">大数据</a><br/>
    <table>
        <tr>
    <c:forEach items="${infor}" var="res">
            <td>${res}</td>
    </c:forEach>
        </tr>
    </table>
    <h3>互动区</h3><br/>
    <a href="${pageContext.request.contextPath}/goAppointServlet">课程预约</a><br/>
    <a href="${pageContext.request.contextPath}/list">问答区</a>


    <h3>练习区</h3><br/>
    <a href="${pageContext.request.contextPath}/">作业区</a><br/>
    <a href="${pageContext.request.contextPath}/goExam.jsp">测试区</a>


</form>

</body>
</html>
