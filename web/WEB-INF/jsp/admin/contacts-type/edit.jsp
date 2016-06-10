<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty type}">
	<jsp:useBean id="type" class="by.vsu.mf.ammc.pm.domain.user.ContactsType"/>
</c:if>
<u:html title="Редактирование типа контактов">
	<c:url var="mainUrl" value="/index.html"/>
	<c:url var="projectListUrl" value="/admin/contacts-type/list.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectListUrl}">Типы контактов</A> :: Редактирование типа контактов</DIV>
	<H2>Редактирование типа контактов</H2>
	<DIV id="page">
		<DIV class="single-column">
			<c:choose>
				<c:when test="${not empty type.id}">
					<H3>Тип контактов «${type.name}»</H3>
				</c:when>
				<c:otherwise>
					<H3>Новый тип контактов</H3>
				</c:otherwise>
			</c:choose>
			<c:url var="contactsTypesSaveUrl" value="/admin/contacts-type/save.html"/>
			<FORM action="${contactsTypesSaveUrl}" method="post">
				<c:if test="${not empty type.id}">
					<INPUT type="hidden" name="id" value="${type.id}">
				</c:if>
				<LABEL for="name">Название типа контакта:</LABEL>
				<INPUT type="text" id="name" name="name" value="${type.name}">
				<LABEL for="regexp">Регулярное выражение для проверки корректности значения контакта:</LABEL>
				<INPUT type="text" id="regexp" name="regexp" value="${type.regexp}">
				<BUTTON type="submit">Сохранить</BUTTON>
				<BUTTON type="reset">Очистить форму</BUTTON>
			</FORM>
			<c:if test="${not empty type.id}">
				<c:url var="contactsTypesDeleteUrl" value="/admin/contacts-type/delete.html"/>
				<FORM action="${contactsTypesDeleteUrl}" method="post">
					<INPUT type="hidden" name="id" value="${type.id}">
					<BUTTON type="submit">Удалить</BUTTON>
				</FORM>
			</c:if>
			<FORM action="${projectListUrl}">
				<BUTTON type="submit">Отменить</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>
