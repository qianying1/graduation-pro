<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示分析数据页</title>
</head>
<body>
	<c:forEach items="${testMap }" var="map">
		${map } <br/>
	</c:forEach>
</body>
</html>