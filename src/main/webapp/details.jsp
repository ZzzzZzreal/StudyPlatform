<%--
  Created by IntelliJ IDEA.
  User: huangwei
  Date: 17-7-24
  Time: 下午7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>资源详情</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
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
                >> >> 资源详情
            </td>
        </tr>
    </table>
</form>
<%--以上是每个页面都有的内容--%>
    <table>
        <%--获取servlet传的参数--%>
        <input type="hidden" value="${u_id}" name="u_id" id="u_id"/>
        <input type="hidden" value="${r_id}" name="r_id" id="r_id"/>

        <tr>
            <td><a href="javascript:history.go(-1);">返回</a></td>
        </tr>

            <caption>${resource.r_name}</caption>
            <tr>
                <td>资源名称：</td>
                <td>${resource.r_name}</td>
            </tr>
            <tr>
                <td>上传时间：</td>
                <td>${resource.r_uptime}</td>
            </tr>
            <tr>
                <td>时长：</td>
                <td>${resource.duration}</td>
            </tr>
            <tr>
                <td>文件类型：</td>
                <td>${resource.r_type}</td>
            </tr>
            <tr>
                <td>文件大小：</td>
                <td>${resource.filesize}</td>
            </tr>
            <tr>
                <td>价格：</td>
                <td>${resource.r_price}</td>
            </tr>
            <tr>
                <td>课程方向：</td>
                <td>${resource.major}</td>
            </tr>
            <tr>
                <td>课程类型:</td>
                <td>${resource.genre}</td>
            </tr>
            <tr>
                <td>描述：</td>
                <td>${resource.desp}</td>
            </tr>
        <script>
            function ckCollect() {
                //获取隐藏域载中的id=u_id,id=r_id 的值
                var u_id=document.getElementById("u_id").value;
                var r_id=document.getElementById("r_id").value;
                //判断用户是否登录
                if(u_id==""){
                    alert("亲，您还没有登录");
                    return;
                }
                //执行ajax
                var url = "${pageContext.request.contextPath}/collection";//请求url
                var data = {"u_id":u_id,"r_id":r_id};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    if(result=="a"){
                        alert("已收藏！")
                    }else if(result=="b"){
                        alert("出错了！")
                    }else if(result=="c"){
                        alert("已取消收藏！")
                    }

                });
            }

            function ckLike() {
                //获取隐藏域载中的id=u_id,id=r_id 的值
                var u_id=document.getElementById("u_id").value;
                var r_id=document.getElementById("r_id").value;
                //判断用户是否登录
                if(u_id==""){
                    alert("亲，您还没有登录");
                    return;//停止程序
                }
                //执行ajax
                var url = "${pageContext.request.contextPath}/like";//请求url
                var data = {"u_id":u_id,"r_id":r_id};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    if(result=="a"){
                        alert("已点赞！")
                    }else if(result=="b"){
                        alert("出错了！")
                    }else if(result=="c"){
                        alert("已取消点赞！")
                    }

                });
            }
            function ckURL() {
                //获取隐藏域载中的id=u_id,id=r_id 的值
                var u_id=document.getElementById("u_id").value;
                var r_id=document.getElementById("r_id").value;
                //判断用户是否登录
                if(u_id==""){
                    alert("亲，您还没有登录");
                    return;//停止程序
                }
                //执行ajax
                var url = "${pageContext.request.contextPath}/download";//请求url
                var data = {"u_id":u_id,"r_id":r_id};//参数
                $.get(url,data,function(result){//get请求执行，result：返回数据
                    if(result=="true"){
                        alert("成功添加至缓存列表")
                    }else if(result=="false"){
                        alert("亲，请先购买后才可以下载哦")
                    }else if(result=="error"){
                        alert("下载失败！");
                    }
                });
            }
        </script>
        <tr>
            <td colspan="2" align="center">
                <a href="javascript:void(0);" onclick="ckCollect()">收藏</a>&nbsp;
                <a href="javascript:void(0);" onclick="ckURL()">下载</a>&nbsp;
                <a href="${pageContext.request.contextPath}/share?u_id=${u_id}&r_id=${r_id}">分享</a>&nbsp;
                <a href="javascript:void(0);" onclick="ckLike()">点赞</a>&nbsp;
            </td>
        </tr>
        <form action="${pageContext.request.contextPath}/purchase" method="post">
            <tr>
                <input type="hidden" value="${r_id}" name="r_id" />
                <input type="hidden" value="${resource.r_price}" name="r_price" />

                <td align="center">
                    <input type="submit" value="购买"/>${note}
                </td>
        </form>

        </tr>
    </table>
</body>
</html>
