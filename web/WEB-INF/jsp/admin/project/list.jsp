<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Проекты">
	<c:url var="mainUrl" value="/index.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Проекты</DIV>
	<H2>Проекты</H2>
	<DIV id="page">
		<DIV class="main-column">
			<c:choose>
				<c:when test="${not empty category}">
					<H3>Проекты категории «${category.name}»</H3>
					<TABLE>
						<TR>
							<TH class="insignificant">№</TH>
							<TH>Название</TH>
							<TH>Менеджер</TH>
						</TR>
						<c:forEach var="project" items="${projects}">
							<c:url var="projectEditUrl" value="/admin/project/edit.html">
								<c:param name="id" value="${project.id}" />
							</c:url>
							<TR>
								<TD class="insignificant">${project.id}</TD>
								<TD><A href="${projectEditUrl}">${project.name}</A></TD>
								<TD><u:person value="${project.manager}"/></TD>
							</TR>
						</c:forEach>
					</TABLE>
					<c:url var="projectEditUrl" value="/admin/project/edit.html"/>
					<FORM action="${projectEditUrl}">
						<INPUT type="hidden" name="category" value="${category.id}"/>
						<BUTTON type="submit">Добавить проект</BUTTON>
					</FORM>
				</c:when>
				<c:otherwise>
					<H3>Не выбрана категория проектов</H3>
				</c:otherwise>
			</c:choose>
		</DIV>
		<DIV class="side-column">
			<H3>Категории проектов</H3>
			<UL>
				<u:hierarchy entities="${categories}" url="/admin/project/list.html" idparam="category"/>
			</UL>
			<c:url var="projectCategoryListUrl" value="/admin/project/category/list.html"/>
			<FORM action="${projectCategoryListUrl}">
				<BUTTON type="submit">Редактировать категории</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>