<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: po111
  Date: 2024-03-31
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>디테일</title>
  </head>
  <body>
  <table border="1">
    <!-- 테이블 헤더 -->
    <thead>
    <tr>
      <th>년도</th>
      <th>학기</th>
      <th>교과목명</th>
      <th>교과구분</th>
      <th>담당교수</th>
      <th>학점</th>

    </tr>
    </thead>
    <!-- 테이블 바디 -->
    <tbody>
    <c:forEach var="offer" items="${id_offer}">
      <tr>

        <td><c:out value="${offer.year}" /></td>
        <td><c:out value="${offer.semester}" /></td>
        <td><c:out value="${offer.subject_name}" /></td>
        <td><c:out value="${offer.subject_classification}" /></td>
        <td><c:out value="${offer.professor}" /></td>
        <td><c:out value="${offer.grades}" /></td>

      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
