<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-11
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >

</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
    <table class="formtable">
        <tr>
            <td class="label"> 교과목명:</td>
            <td><sf:input class="control" type="text" path="subject_name"/>  <br/>
                <sf:errors path="subject_name" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 교과구분:</td>
            <td><sf:input class="control" type="text" path="subject_classification"/> <br/>
                <sf:errors path="subject_classification" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 담당교수:</td>
            <td><sf:textarea class="control" rows="10" cols="10" path="professor"/> <br/>
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:textarea class="control" rows="10" cols="10" path="grades"/> <br/>
                <sf:errors path="grades" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="새 제안"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
