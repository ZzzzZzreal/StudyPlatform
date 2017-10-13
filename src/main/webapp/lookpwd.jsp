<%--
  Created by IntelliJ IDEA.
  User: ch
  Date: 17-7-25
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<html>
<head>
    <title>找回密码</title>
    <script>


        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#username").blur(function(){//得到email标签，并注册事件
                var username = $(this).val();//得到emial的值
                var na = $("#na");//得到第一个font标签
                na.html("用户名输入正确").css("color","");//设置内容
                if(username==""||username.length>6){
                    na.html("用户名不能为空且小于六位").css("color","red");//设置内容颜色为红色
                    return;
                }
                //执行ajax
                var url = "${pageContext.request.contextPath}/CKusersNameServlet";//请求url
                var data = {"username":username};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    //alert(result);
                    if(result==true){
                        na.html("此用户不存在!!").css("color","red");

                    }else{
                        //alert(result);
                        na.html("用户名输入正确").css("color","lime");
                    }
                });

            });
        });

        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#phone").blur(function(){//得到email标签，并注册事件
                var phone = $(this).val();//得到emial的值
                var ph = $("#ph");//得到第一个font标签
                ph.html("手机输入正确").css("color","");//设置内容
                var myRegex = /1[3-8][0-9]{9}/;
                var p=myRegex.test(phone);
                if(""==phone|| !myRegex.test(phone)){
                    ph.html("无效的手机号码").css("color","red");//设置内容颜色为红色
                    return;
                }

            });
        });

    </script>


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
                >> >> 找回密码
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
<div align="center">
    <caption>==========找回密码==========</caption>
    <form  action="${pageContext.request.contextPath}/look" method="post"  >
        <table border="3" align="center">
            <tr>
                <td align="center">用户名：</td>
                <td><input type="text" name="username" id="username"></input>
                </td>
                <td>
                    <h5 id="na"></h5>
                </td>
            </tr>
            <tr>
                <td align="center">手机号:</td>
                <td>
                    <input type="text" name="phone" id="phone"></input>
                </td>
                <td>
                    <h5 id="ph"></h5>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                        <a href="index.jsp"><input type="button" value="返回首页"></input></a>
                        <input type="submit" value="下一步" />
                        <input type="reset" value="重置"/>
                        <a href="login.jsp"><input type="button" value="我不改了!!!"></input></a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
