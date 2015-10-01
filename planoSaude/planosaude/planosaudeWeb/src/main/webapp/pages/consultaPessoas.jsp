<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap-theme.min.css">
<title>Consulta de Pessoas</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<div class="navbar-brand" >Todas as pessoas Cadastradas</div>
			</div>
		</div>
	</nav>
	<table class="table table-hover" style="width: 100%;">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Tipo de Plano</th>
				<th style="text-align: center;">Data de Vencimento do Plano</th>
				<th>Cidade</th>
				<th>UF</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pessoa" items="${listPessoas}">
				<tr>
					<td>${pessoa.id}</td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.tipoPlano}</td>
					<td style="text-align: center;"><fmt:formatDate
							pattern="dd/MM/yyyy" value="${pessoa.dataVencimentoPlano.date}" /></td>
					<td>${pessoa.endereco.cidade}</td>
					<td>${pessoa.endereco.uf}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>