<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>fascicolo-sanitario-web</title>

<tiles:importAttribute name="cssList" />
<tiles:importAttribute name="jsList" />

<c:forEach items="${cssList}" var="css">
	<link rel="stylesheet" href='<%=request.getContextPath()%>/<c:out value="${css}" />' >
</c:forEach>
<c:forEach items="${jsList}" var="js">
	<script type="text/javascript" src='<%=request.getContextPath()%>/<c:out value="${js}" />'></script>
</c:forEach>
</head>
<body>
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />
</body>

</html>