<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 9.
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 자바코드의 일부분을 스크립트로 조금 씀
        // 스크립트릿(스크립트 + let(작은 프로그램))
        // jsp에 코드한 부분은 서블릿으로 변환될 때 service() 안으로 다 들어감.
        int count = 0;
        count = 100;
    %>
    <h1>변수 출력(count) : <%=count%></h1>
    <%--%= : 표현식(출력, expression language; EL) --%>
    <%--자바 주석. //로 변환. 브라우저에 전송되지 않음--%>
    <!--html 주석. 브라우저에 전송됨-->
    <%--Ctrl + / : jsp 자바용 주석 자동 완성--%>
    <hr>
    <%@include file="copyright.jsp"%>
    <hr>

    <%
        int sum = 10;
        if (sum >= 10) {
    %>
    <h1>합이 매우 커요</h1>
    <%
        } else {
    %>
    <h1>합이 적어요</h1>
    <%
        }
    %>
    <hr>
    <%
        Date date = new Date();
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();
    %>
    <h1>현재 시각</h1>
    <h1><%=hour%>시 <%=min%>분 <%=sec%>초</h1>
    <h1><%= date.getDate()%></h1>
    <h1><%= date.getDay()%></h1>
</body>
</html>
