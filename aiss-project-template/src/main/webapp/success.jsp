<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Playlist Search</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<fieldset id="Youtube">

<legend>Playlist: <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.canciones}" var="cancion">
	<span>Song: <c:out value="${cancion.snippet.title}"/></span><br/>
</c:forEach>
</fieldset>
<a href="/AuthController/Spotify">Importar a Spotify.</a>
</body>
</html>