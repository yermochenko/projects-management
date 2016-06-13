<%--
  Created by IntelliJ IDEA.
  User: Timofei
  Date: 08.06.2016
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty user}">
	<jsp:useBean id="user" class="by.vsu.mf.ammc.pm.domain.user.User"/>
</c:if>
<u:html title="Редактирование пользователя">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="userListUrl" value="/admin/user/list.html">
		<c:choose>
			<c:when test="${not empty user.id}">
				<c:param name="group" value="${user.group.id}"/>
			</c:when>
			<c:otherwise>
				<c:param name="group" value="${group.id}"/>
			</c:otherwise>
		</c:choose>
	</c:url>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${userListUrl}">Пользователи</A> :: Редактирование пользователя</DIV>
	<H2>Редактирование пользователя</H2>
	<DIV id="page">
		<DIV class="main-column">
			<c:choose>
				<c:when test="${not empty user.id}">
					<H3>Пользователь «${user.name}»</H3>
				</c:when>
				<c:otherwise>
					<H3>Новый пользователь</H3>
				</c:otherwise>
			</c:choose>
			<c:url var="userSaveUrl" value="/admin/user/save.html"/>
			<FORM action="${userSaveUrl}" method="post">
				<c:if test="${not empty user.id}">
					<INPUT type="hidden" name="id" value="${user.id}">
				</c:if>
				<LABEL for="name">Псевдоним:</LABEL>
				<INPUT type="text" id="name" name="name" value="${user.name}">
				<LABEL for="last-name">Фамилия:</LABEL>
				<INPUT type="text" id="last-name" name="last-name" value="${user.lastName}">
				<LABEL for="first-name">Имя:</LABEL>
				<INPUT type="text" id="first-name" name="first-name" value="${user.firstName}">
				<LABEL for="middle-name">Отчество:</LABEL>
				<INPUT type="text" id="middle-name" name="middle-name" value="${user.middleName}">
				<LABEL for="group">Группа:</LABEL>
				<SELECT id="group" name="group">
					<c:choose>
						<c:when test="${not empty user.id}">
							<u:select-hierarchy entities="${groups}" id="${user.group.id}"/>
						</c:when>
						<c:otherwise>
							<u:select-hierarchy entities="${groups}" id="${group.id}"/>
						</c:otherwise>
					</c:choose>
				</SELECT>
				<c:if test="${user.admin}">
					<c:set var="checked" value=" checked"/>
				</c:if>
				<LABEL for="is-admin"><INPUT type="checkbox" id="is-admin" name="is-admin" value="checked"${checked}>Администратор</LABEL>
				<BUTTON type="submit">Сохранить</BUTTON>
				<BUTTON type="reset">Очистить форму</BUTTON>
			</FORM>
			<c:if test="${not empty user.id}">
				<c:url var="userDeleteUrl" value="/admin/user/delete.html"/>
				<FORM action="${userDeleteUrl}" method="post">
					<INPUT type="hidden" name="id" value="${user.id}">
					<BUTTON type="submit">Удалить</BUTTON>
				</FORM>
			</c:if>
			<c:url var="userListUrl" value="/admin/user/list.html"/>
			<FORM action="${userListUrl}">
				<c:choose>
					<c:when test="${not empty user.id}">
						<INPUT type="hidden" name="group" value="${user.group.id}">
					</c:when>
					<c:otherwise>
						<INPUT type="hidden" name="group" value="${group.id}">
					</c:otherwise>
				</c:choose>
				<BUTTON type="submit">Отменить</BUTTON>
			</FORM>
		</DIV>
		<DIV class="side-column">
			<H3>Группы пользователей</H3>
			<UL>
				<u:hierarchy entities="${groups}" url="/admin/user/list.html" idparam="group"/>
			</UL>
			<c:url var="userGroupListUrl" value="/admin/user/group/list.html"/>
			<FORM action="${userGroupListUrl}">
				<BUTTON type="submit">Редактировать группы</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>