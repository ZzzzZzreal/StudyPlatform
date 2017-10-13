<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<html>
<head>
    <title>注册</title>
    <script language="javascript">
        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#email").blur(function(){//得到email标签，并注册事件
                var email = $(this).val();//得到emial的值
                var em = $("#em");//得到第一个font标签
                em.html("邮箱设置成功").css("color","");//设置内容
                if (""==email){
                    em.html("邮箱不能为空").css("color","red");//设置内容颜色为红色
                    return;
                }
                var myRegex1 = /[1-9][0-9]{5,10}@qq\.com/;
                if(!myRegex1.test(email)){
                    em.html("邮箱不合法").css("color","red");//设置内容颜色为红色
                    return;
                }
                //执行ajax
                var url = "${pageContext.request.contextPath}/CKemailServlet";//请求url
                var data = {"email":email};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    //alert(result);
                    if(result==true){
                        em.html("邮箱可以使用").css("color","lime");
                    }else{
                        em.html("邮箱以被使用").css("color","red");
                    }
                });

            });
        });

        function myReload() {
            document.getElementById("CreateCheckCode").src = "${pageContext.request.contextPath}/pictureCheckCode?time="
                + new Date().getTime();
        }


        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#checkCode").blur(function(){//得到email标签，并注册事件
                var checkCode = $(this).val();//得到emial的值
                var ch = $("#ch");//得到第一个font标签
                ch.html("检验码输入正确").css("color","");//设置内容
                if(checkCode==""){
                    ch.html("请输入检验码").css("color","red");//设置内容颜色为红色
                    return;
                }
                //执行ajax
                var url = "${pageContext.request.contextPath}/CkcodeServlet";//请求url
                var data = {"checkCode":checkCode};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    //alert(result);
                    if(result==true){

                        ch.html("检验码输入正确").css("color","lime");
                    }else{
                        //alert(result);
                        ch.html("请输入正确的检验码").css("color","red");
                    }
                });

            });
        });








        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#username").blur(function(){//得到email标签，并注册事件
                var username = $(this).val();//得到emial的值
                var na = $("#na");//得到第一个font标签
                na.html("用户名设置成功").css("color","");//设置内容
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

                        na.html("用户名可以使用").css("color","lime");
                    }else{
                        //alert(result);
                        na.html("用户名以被使用").css("color","red");
                    }
                });

            });
        });


        $(function(){
            //当id为email的标签失去焦点时触发此事件
            $("#phone").blur(function(){//得到email标签，并注册事件
                var phone = $(this).val();//得到emial的值
                var ph = $("#ph");//得到第一个font标签
                ph.html("手机号设置成功").css("color","");//设置内容
                var myRegex = /1[3-8][0-9]{9}/;
                var p=myRegex.test(phone);
                if(""==phone|| !myRegex.test(phone)){
                    ph.html("无效的手机号码").css("color","red");//设置内容颜色为红色
                    return;
                }

                //执行ajax
                var url = "${pageContext.request.contextPath}/CKphoneServlet";//请求url
                var data = {"phone":phone};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    //alert(result);
                    if(result==true){
                        ph.html("手机号可以使用").css("color","lime");
                    }else{
                        ph.html("手机号以被使用").css("color","red");
                    }
                });

            });
        });
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
                    pw1.html("密码可以使用").css("color","lime");
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
                <a href="${pageContext.request.contextPath}/userCenter.jsp">&nbsp;&nbsp;个&nbsp;人&nbsp;中&nbsp;心&nbsp;&nbsp;</a>
            </td>
        </tr>

        <tr>
            <td colspan="4">
                >> >> 用户注册
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
<div align="center">
<caption>==========用户注册==========</caption>
<form  action="${pageContext.request.contextPath}/zuce" method="post" >
    <table border="3" align="center">

        <tr>
            <td align="center">用户名：</td>
            <td><input type="text" name="username" id="username" >(用户名必须小于六位)</input>
            </td>
            <td>
                <h5 id="na"></h5>
            </td>
        </tr>
        <tr>
            <td align="center">密--码：</td>
            <td>
                <input type="password" name="password" id="password">(密码必须大于六位)</input>
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
            <td align="center">邮--箱：</td>
            <td><input type="text" name="email"  id="email">(仅支持QQ邮箱)</input>
            </td>
            <td>
                <h5 id="em"></h5>
            </td>
        </tr>
        <tr>
            <td align="center">手机号:</td>
            <td>
               +86 <input type="text" name="phone" id="phone">(仅支持大陆11位手机号)</input>
            </td>
            <td>
                <h5 id="ph"></h5>
            </td>
        </tr>
        <tr>
            <td align="center">性--别：</td>
            <td>
                <input type="radio" name="gender" checked="checked" value="男">男</input>
                <input type="radio" name="gender" value="女">女</input>
            </td>
        </tr>
        <tr>
            <td>选择身份</td>
            <td>
                <input type="radio" name="identify" checked="checked" value="普通用户">普通用户</input>
                <input type="radio" name="identify" value="学员">学员</input>
            </td>

        </tr>
        <tr>
            <td align="center">个人介绍：</td>
            <td colspan="2">
                <textarea class="textarea" name="introduce"></textarea>
            </td>
        </tr>
        <tr>
            <td>校验码:</td>
            <td>
                    <input name="checkCode" type="text" id="checkCode" title="验证码区分大小写"
                           size="8" ,maxlength="4" />
                    <img src="${pageContext.request.contextPath}/pictureCheckCode" id="CreateCheckCode" align="middle">
                    <a href="javascript:void(0);" onclick="myReload()"> 看不清,换一个</a>
            </td>
            <td>
                <h5 id="ch"></h5>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                    <input type="submit" value="注册" />${mss}${msg}
                    <input type="reset" value="重置"/>

            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>