<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty category}">
	<jsp:useBean id="category" class="by.vsu.mf.ammc.pm.domain.project.ProjectsCategory"/>
</c:if>
<u:html title="Редактирование категории проектов">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="projectListUrl" value="/admin/project/list.html"/>
	<c:url var="categoryListUrl" value="/admin/project/category/list.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectListUrl}">Проекты</A> :: <A href="${categoryListUrl}">Категории проектов</A> :: Редактирование категоии проектов</DIV>
	<H2>Редактирование категории проектов</H2>
	<DIV id="page">
		<DIV class="single-column">
			<c:choose>
				<c:when test="${not empty category.id}">
					<H3>Категория проектов «${category.name}»</H3>
				</c:when>
				<c:otherwise>
					<H3>Новая категория проектов</H3>
				</c:otherwise>
			</c:choose>
			<c:url var="categorySaveUrl" value="/admin/project/category/save.html"/>
			<FORM action="${categorySaveUrl}" method="post">
				<c:if test="${not empty category.id}">
					<INPUT type="hidden" name="id" value="${category.id}">
				</c:if>
				<LABEL for="category">Родительская категория:</LABEL>
				<SELECT id="category" name="parent">
					<OPTION>&ndash;</OPTION>
					<c:choose>
						<c:when test="${not empty category.parent}">
							<u:select-hierarchy entities="${categories}" id="${category.parent.id}"/>
						</c:when>
						<c:otherwise>
							<u:select-hierarchy entities="${categories}"/>
						</c:otherwise>
					</c:choose>
				</SELECT>
				<LABEL for="name">Название категории проектов:</LABEL>
				<INPUT type="text" id="name" name="name" value="${category.name}">
				<BUTTON type="submit">Сохранить</BUTTON>
				<BUTTON type="reset">Очистить форму</BUTTON>
			</FORM>
			<c:if test="${not empty category.id}">
				<c:url var="categoryDeleteUrl" value="/admin/project/category/delete.html"/>
				<FORM action="${categoryDeleteUrl}" method="post">
					<INPUT type="hidden" name="id" value="${category.id}">
					<BUTTON type="submit">Удалить</BUTTON>
				</FORM>
			</c:if>
			<FORM action="${categoryListUrl}">
				<BUTTON type="submit">Отменить</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>