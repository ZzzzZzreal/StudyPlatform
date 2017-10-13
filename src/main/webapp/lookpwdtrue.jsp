<%--
  Created by IntelliJ IDEA.
  User: ch
  Date: 17-7-25
  Time: 下午3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>>
<html>
<head>
    <title>重置密码</title>
    <script>
        var pwd="";
        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#password").blur(function(){//得到email标签，并注册事件
                var password = $(this).val();//得到emial的值
                var pw = $("#pw");//得到第一个font标签
                pw.html("请输入有效的密码").css("color","");//设置内容
                if(password==""||password.length<=6){
                    pw.html("密码不能为空且大于六位").css("color","red");//设置内容颜色为红色
                    return;
                }else{
                    pw.html("密码可以使用").css("color","lime");
                }
                pwd=password;
            });
        });

        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#password1").blur(function(){//得到email标签，并注册事件
                var password1 = $(this).val();//得到emial的值
                var pw1 = $("#pw1");//得到第一个font标签
                pw1.html("密码设置成功").css("color","");//设置内容
                if(password1!=pwd){
                    pw1.html("俩次密码输入不一致").css("color","red");//设置内容颜色为红色
                    return;
                }else{
                    pw.html("密码可以使用").css("color","lime");
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
                >> >> 重置密码
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
<div align="center">
    <caption>==========重置密码==========</caption>
    <form  action="${pageContext.request.contextPath}/looktrue" method="post"  >
        <table border="3" align="center">
            <input type="hidden" name="u_id" value="${u_id}"/>
                <td align="center">密--码：</td>
                <td>
                    <input type="password" name="password" id="password"></input>
                </td>
                <td>
                    <h5 id="pw"></h5>
                </td>
            </tr>
            <tr>
                <td  align="center">确认密码：</td>
                <td>
                    <input type="password" name="repassword" id="password1"></input>
                </td>
                <td>
                    <h5 id="pw1"></h5>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form>
                        <input type="submit" value="完成修改"/>
                        <a href="lookpwd.jsp"><input type="button" value="返回登陆"></input></a>
                        <input type="reset" value="重置"/>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
