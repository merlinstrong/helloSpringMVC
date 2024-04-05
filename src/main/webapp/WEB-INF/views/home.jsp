<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>학사정보 시스템</title>
</head>
<body>
<p>학사정보 시스템</p>
<p><a href="${pageContext.request.contextPath}/login">로그인</a></p>
<p><a href="${pageContext.request.contextPath}/offers">학년별 이수학점 조회</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">수강신청</a></p>
<p><a href="${pageContext.request.contextPath}/details?year=2024&semester=2">수강신청조회</a></p>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <a href="javascript:document.getElementById('logout').submit()">로그아웃</a>
</c:if>

<form id="logout" action="<c:url value='/logout' />" method="post">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>

