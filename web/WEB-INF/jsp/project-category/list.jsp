<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Категории проектов">
	<c:url var="mainUrl" value="/index.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Категории проектов</DIV>
	<H2>Список категорий проектов</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>Список категорий проектов</H3>
			<u:project_category categories="${category}"/>
			<c:url var="editUrl" value="/project_category/edit.html"/>
			<FORM action="${editUrl}">
				<BUTTON type="submit">Добавить категорию</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>
