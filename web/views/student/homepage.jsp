<%--
  Created by IntelliJ IDEA.
  User: stonezhang
  Date: 2017/3/1
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="tc.bean.StudentInfoVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="studentInfoVO"
             type="tc.bean.StudentInfoVO"
             scope="session"></jsp:useBean>
<div>
    <%=studentInfoVO.getId()%>
</div>

<div>
    <%=studentInfoVO.getBankCard()%>
</div>

<div>
    <%=studentInfoVO.getPassword()%>
</div>
</body>
</html>

