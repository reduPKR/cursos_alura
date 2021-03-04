<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List, br.com.alura.gerenciador.servlet.*"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard TagLib</title>
</head>
<body>

	Lista de Empresas: <br/>
	
	<ul> 
		<c:forEach items="${empresas}" var="empresa"> 
		<li>
			${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="/gerenciador/remove-empresa?id=${empresa.id}">remover</a>
			<a href="/gerenciador/alterar-empresa?id=${empresa.id}">editar</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>