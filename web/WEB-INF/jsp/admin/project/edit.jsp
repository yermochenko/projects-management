<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty project}">
	<jsp:useBean id="project" class="by.vsu.mf.ammc.pm.domain.project.Project"/>
</c:if>
<u:html title="Редактирование проекта">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="projectListUrl" value="/admin/project/list.html">
		<c:choose>
			<c:when test="${not empty project.id}">
				<c:param name="category" value="${project.category.id}"/>
			</c:when>
			<c:otherwise>
				<c:param name="category" value="${category.id}"/>
			</c:otherwise>
		</c:choose>
	</c:url>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectListUrl}">Проекты</A> :: Редактирование проекта</DIV>
	<H2>Редактирование проекта</H2>
	<DIV id="page">
		<DIV class="main-column">
			<c:choose>
				<c:when test="${not empty project.id}">
					<H3>Проект «${project.name}»</H3>
				</c:when>
				<c:otherwise>
					<H3>Новый проект</H3>
				</c:otherwise>
			</c:choose>
			<c:url var="projectSaveUrl" value="/admin/project/save.html"/>
			<FORM action="${projectSaveUrl}" method="post">
				<c:if test="${not empty project.id}">
					<INPUT type="hidden" name="id" value="${project.id}">
				</c:if>
				<LABEL for="name">Название:</LABEL>
				<INPUT type="text" id="name" name="name" value="${project.name}">
				<LABEL for="category">Категория:</LABEL>
				<SELECT id="category" name="category">
					<c:choose>
						<c:when test="${not empty project.id}">
							<u:select-hierarchy entities="${categories}" id="${project.category.id}"/>
						</c:when>
						<c:otherwise>
							<u:select-hierarchy entities="${categories}" id="${category.id}"/>
						</c:otherwise>
					</c:choose>
				</SELECT>
				<LABEL for="manager">Менеджер:</LABEL>
				<SELECT id="manager" name="manager">
					<c:forEach var="user" items="${users}">
						<c:choose>
							<c:when test="${not empty project.id and project.manager.id == user.id}">
								<c:set var="selected" value=" selected"/>
							</c:when>
							<c:otherwise>
								<c:remove var="selected"/>
							</c:otherwise>
						</c:choose>
						<OPTION value="${user.id}"${selected}><u:person value="${user}"/></OPTION>
					</c:forEach>
				</SELECT>
				<BUTTON type="submit">Сохранить</BUTTON>
				<BUTTON type="reset">Очистить форму</BUTTON>
			</FORM>
			<c:if test="${not empty project.id}">
				<c:url var="projectDeleteUrl" value="/admin/project/delete.html"/>
				<FORM action="${projectDeleteUrl}" method="post">
					<INPUT type="hidden" name="id" value="${project.id}">
					<BUTTON type="submit">Удалить</BUTTON>
				</FORM>
			</c:if>
			<c:url var="projectListUrl" value="/admin/project/list.html"/>
			<FORM action="${projectListUrl}">
				<c:choose>
					<c:when test="${not empty project.id}">
						<INPUT type="hidden" name="category" value="${project.category.id}">
					</c:when>
					<c:otherwise>
						<INPUT type="hidden" name="category" value="${category.id}">
					</c:otherwise>
				</c:choose>
				<BUTTON type="submit">Отменить</BUTTON>
			</FORM>
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