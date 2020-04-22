<%--
  Created by IntelliJ IDEA.
  User: GZX
  Date: 2020/4/22
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500错误页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/error/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/error/js/preloader.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/error/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/error/js/css_browser_selector.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/error/js/plax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/error/js/jquery.spritely-0.6.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/error/js/jquery-animate-css-rotate-scale.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/error/js/script.js"></script>
</head>
<body >
<div id="indicator"></div>
<div class="wrapper">
    <div class="sky init">
        <div id="clouds" class="clouds init"> </div>
    </div>
    <div class="convas init">
        <div id="mountain" class="mountain"></div>
        <div class="ground"></div>
        <div class="holder">
            <div class="rocks"></div>
            <div class="work-sign"></div>
            <div class="text-sign">
                <div class="text font">
                    Server error! We're Working Hard...
                </div>
            </div>
            <div class="init hole">
                <div class="sweat"></div>
                <div class="worker swing "></div>
                <div class="ground-bottom">
                    <div class="cleaner"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
