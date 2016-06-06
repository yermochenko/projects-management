<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:choose>
	<c:when test="${not empty pageContext.exception}">
		<c:set var="message" value="Ошибка работы с базой данных"/>
	</c:when>
	<c:otherwise>
		<c:set var="message" value="Непредвиденная ошибка приложения"/>
	</c:otherwise>
</c:choose>
<u:html title="Ошибка">
	<c:url var="rootUrl" value="/index.html"/>
	<DIV id="breadcrumbs"><A href="${rootUrl}">Главная</A></DIV>
	<H2>Ошибка в приложении</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>${message}</H3>
		</DIV>
	</DIV>
</u:html>