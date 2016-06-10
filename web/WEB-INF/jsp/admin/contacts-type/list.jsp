<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Типы контактов">
	<c:url var="mainUrl" value="/index.html"/>
	<DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Типы контактов</DIV>
	<H2>Типы контактов</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>Список типов контактов</H3>
			<TABLE>
				<TR>
					<TH class="insignificant">№</TH>
					<TH>Название</TH>
					<TH>Регулярное выражение</TH>
				</TR>
				<c:forEach var="type" items="${types}">
					<TR>
						<TD class="insignificant">${type.id}</TD>
						<c:url var="editUrl" value="/admin/contacts-type/edit.html"><c:param name="id" value="${type.id}"/></c:url>
						<TD><A href="${editUrl}">${type.name}</A></TD>
						<TD><CODE>${type.regexp}</CODE></TD>
					</TR>
				</c:forEach>
			</TABLE>
			<c:url var="editUrl" value="/admin/contacts-type/edit.html"/>
			<FORM action="${editUrl}">
				<BUTTON type="submit">Добавить тип контактов</BUTTON>
			</FORM>
		</DIV>
	</DIV>
</u:html>
