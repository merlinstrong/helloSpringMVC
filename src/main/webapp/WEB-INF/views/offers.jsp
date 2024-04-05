<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-07
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
    <!-- 테이블 헤더 -->
    <thead>
    <tr>
    <th>년도</th>
    <th>학기</th>
    <th>취득학점</th>
    <th>상세보기</th>

    </tr>
    </thead>
    <!-- 테이블 바디 -->
    <tbody>
    <c:forEach var="semesterCredits" items="${id_semesterCredits}" varStatus="status">
        <!-- 마지막 항목이 아닌 경우 -->
        <c:if test="${!status.last}">
            <tr>
                <td><c:out value="${semesterCredits.year}" /></td>
                <td><c:out value="${semesterCredits.semester}" /></td>
                <td><c:out value="${semesterCredits.totalSemesterCredits}" /></td>
                <td><a href="${pageContext.request.contextPath}/details?year=${semesterCredits.year}&semester=${semesterCredits.semester}">상세보기</a></td>
            </tr>
        </c:if>

        <!-- 마지막 항목인 경우 -->
        <c:if test="${status.last}">
            <tr>
                <!-- 마지막 항목에 대한 다른 내용을 여기에 작성합니다. -->
                <td>총계</td>
                <td> </td>
                <td><c:out value="${semesterCredits.totalSemesterCredits}" /></td>
                <td> </td>
            </tr>
        </c:if>
    </c:forEach>

    </tbody>
    </table>
</body>
</html>
