<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Категории проектов">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="projectsUrl" value="/admin/project/list.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectsUrl}">Проекты</A> :: Категории проектов</DIV>
	<H2>Категории проектов</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>Список категорий проектов</H3>
			<c:choose>
				<c:when test="${not empty categories}">
					<UL>
						<u:hierarchy entities="${categories}" url="/admin/project/category/edit.html"/>
					</UL>
				</c:when>
				<c:otherwise>Список пуст</c:otherwise>
			</c:choose>
			<c:url var="editUrl" value="/admin/project/category/edit.html"/>
			<FORM action="${editUrl}">
				<BUTTON type="submit">Добавить категорию проектов</BUTTON>
			</FORM>
			<FORM action="${projectsUrl}">
				<BUTTON type="submit">Закончить редактирование категорий</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>