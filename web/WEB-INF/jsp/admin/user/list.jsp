<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Пользователи">
	<c:url var="mainUrl" value="/index.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Пользователи</DIV>
	<H2>Пользователи</H2>
	<DIV id="page">
		<DIV class="main-column">
			<c:choose>
				<c:when test="${not empty group}">
					<H3>Пользователи группы «${group.name}»</H3>
					<TABLE>
						<TR>
							<TH class="insignificant">№</TH>
							<TH>Псевдоним</TH>
							<TH>Фамилия</TH>
							<TH>Имя</TH>
							<TH>Отчество</TH>
						</TR>
						<c:forEach var="user" items="${users}">
							<c:url var="userEditUrl" value="/admin/user/edit.html">
								<c:param name="id" value="${user.id}" />
							</c:url>
							<TR>
								<TD class="insignificant">${user.id}</TD>
								<TD><A href="${userEditUrl}">${user.name}</A></TD>
								<TD>${user.lastName}</TD>
								<TD>${user.firstName}</TD>
								<TD>${user.middleName}</TD>
							</TR>
						</c:forEach>
					</TABLE>
					<c:url var="userEditUrl" value="/admin/user/edit.html" />
					<FORM action="${userEditUrl}">
						<INPUT type="hidden" name="group" value="${group.id}"/>
						<BUTTON type="submit">Добавить пользователя</BUTTON>
					</FORM>
				</c:when>
				<c:otherwise>
					<H3>Не выбрана группа пользователей</H3>
				</c:otherwise>
			</c:choose>
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