<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 08.06.2016
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty group}">
	<jsp:useBean id="group" class="by.vsu.mf.ammc.pm.domain.user.UsersGroup"/>
</c:if>
<u:html title="Редактирование группы пользователей">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="groupListUrl" value="/admin/user/group/list.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${groupListUrl}">Группы пользователей</A> :: Редактирование группы пользователей</DIV>
	<H2>Редактирование группы пользователей</H2>
	<DIV id="page">
		<DIV class="single-column">
			<c:choose>
				<c:when test="${not empty group.id}">
					<H3>Группа пользователей «${group.name}»</H3>
				</c:when>
				<c:otherwise>
					<H3>Новая группа пользователей</H3>
				</c:otherwise>
			</c:choose>
			<c:url var="groupSaveUrl" value="/admin/user/group/save.html"/>
			<FORM action="${groupSaveUrl}" method="post">
				<c:if test="${not empty group.id}">
					<INPUT type="hidden" name="id" value="${group.id}">
				</c:if>
				<LABEL for="group">Родительская группа:</LABEL>
				<SELECT id="group" name="parent_id">
					<OPTION>&ndash;</OPTION>
					<c:choose>
						<c:when test="${not empty group.parent}">
							<u:select-hierarchy entities="${groups}" id="${group.parent.id}"/>
						</c:when>
						<c:otherwise>
							<u:select-hierarchy entities="${groups}"/>
						</c:otherwise>
					</c:choose>
				</SELECT>
				<LABEL for="name">Имя группы пользователей:</LABEL>
				<INPUT type="text" id="name" name="name" value="${group.name}">
				<BUTTON type="submit">Сохранить</BUTTON>
				<BUTTON type="reset">Очистить форму</BUTTON>
			</FORM>
			<c:if test="${not empty group.id}">
				<c:url var="groupDeleteUrl" value="/admin/user/group/delete.html"/>
				<FORM action="${groupDeleteUrl}" method="post">
					<INPUT type="hidden" name="id" value="${group.id}">
					<BUTTON type="submit">Удалить</BUTTON>
				</FORM>
			</c:if>
			<FORM action="${groupListUrl}">
				<BUTTON type="submit">Отменить</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>