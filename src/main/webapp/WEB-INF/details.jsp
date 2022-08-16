<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row mt-2">
			<h1 class="text-success col">Language Details</h1>
			<a href="/languages" class="col mt-3">Dashboard</a>
		</div>
		<div class="row mt-2">
			<p>
				<label>Name:</label>
				<c:out value="${language.getName()}" />
			</p>
			<p>
				<label>Creator:</label>
				<c:out value="${language.getCreator()}" />
			</p>
			<p>
				<label>Version:</label>
				<c:out value="${language.getVersion()}" />
			</p>

		</div>
		<div class="row mt-2">
			<form action="/languages/delete/${language.getId()}" method="post">
				    <input type="hidden" name="_method" value="delete">     <input
					type="submit" value="Delete" class="btn btn-danger">
			</form>

		</div>
		<div class="row mt-2">
			<form action="/languages/edit/${language.getId()}" method="get">
				         <input type="submit" value="Update" class="btn btn-warning">
			</form>
		</div>
	</div>
</body>
</html>