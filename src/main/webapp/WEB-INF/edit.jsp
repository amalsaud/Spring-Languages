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
		<c:if test="${success != null}">
			<div class="alert alert-success mt-2">
				<c:out value="${success}" />
			</div>
		</c:if>
		<div class="row mt-2">
			<h1 class="text-success col">Edit Language</h1>
			<div class="col-3 mt-2">
				<form action="/languages/delete/${languageId}" method="post"
					class="col">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="btn btn-danger">
				</form>
			</div>
			<a href="/languages" class="col mt-3">Dashboard</a>
		</div>
		<div class="row mt-2">
			<form:errors element="div" path="language.*"
				cssClass="alert alert-danger" />
			<form:form action="/languages/edit/${languageId}" method="post"
				modelAttribute="language">
				<input type="hidden" name="_method" value="put">
				<div class="form-group mt-2">
					<label>Name</label>
					<form:input path="name" type="text" class="form-control"
						cssClass="form-control" cssErrorClass="form-control is-invalid" />
				</div>
				<div class="form-group mt-2">
					<label>Creator</label>
					<form:input path="creator" type="text" class="form-control"
						cssClass="form-control" cssErrorClass="form-control is-invalid" />
				</div>
				<div class="form-group mt-2">
					<label>Version</label>
					<form:input path="version" type="text" class="form-control"
						cssClass="form-control" cssErrorClass="form-control is-invalid" />
				</div>
				<button type="submit" class="btn btn-primary mt-2">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>