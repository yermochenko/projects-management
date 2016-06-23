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
<u:html title="Группы пользователей">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="usersUrl" value="/admin/user/list.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${usersUrl}">Пользователи</A> :: Группы пользователей</DIV>
	<H2>Группы пользователей</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>Список групп пользователей</H3>
			<c:choose>
				<c:when test="${not empty groups}">
					<UL>
						<u:hierarchy entities="${groups}" url="/admin/user/group/edit.html"/>
					</UL>
				</c:when>
				<c:otherwise>Список пуст</c:otherwise>
			</c:choose>
			<c:url var="editUrl" value="/admin/user/group/edit.html"/>
			<FORM action="${editUrl}">
				<BUTTON type="submit">Добавить группу пользователей</BUTTON>
			</FORM>
			<FORM action="${usersUrl}">
				<BUTTON type="submit">Закончить редактирование групп</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>