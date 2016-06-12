<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Категории Заданий">
	<c:url var="mainUrl" value="/index.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Категории Заданий</DIV>
	<H2>Категории Заданий</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>Список категорий заданий</H3>
			<u:tasks-category categories="${categories}"/>
			<c:url var="editUrl" value="/tasks-category/edit.html"/>
			<FORM action="${editUrl}">
				<BUTTON type="submit">Добавить категорию задания</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>
