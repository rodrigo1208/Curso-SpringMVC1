<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista livro</title>
</head>
<body>

	<div>${sucesso }</div>
	
	<h2>Lista de produtos</h2>
	<br />
	<br />
	
	<table>
		<tr>
			<td>Titulo</td>
			<td>Descrição</td>
			<td>Paginas</td>
		</tr>
		<c:forEach items="${produtos }" var="produto">
			<tr>
				<td>${produto.titulo }</td>
				<td>${produto.descricao }</td>
				<td>${produto.paginas }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>