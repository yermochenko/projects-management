<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Список проектов">
    <c:url var="mainUrl" value="/index.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Список проектов</DIV>
    <H2>Список проектов</H2>
    <DIV id="page">
        <DIV class="single-column">
            <H3>Список  проектов</H3>
            <TABLE>
                <TR>
                    <TH class="insignificant">id</TH>
                    <TH>Идентификатор проекта</TH>
                    <TH>Название проекта</TH>
                    <TH>Описание проекта</TH>
                    <TH>Идентификатор котегории проекта</TH>
                    <TH>Идентификатор управляющего проекта</TH>
                </TR>
                <c:forEach var="type" items="${projects}">
                    <TR>
                        <TD class="insignificant">${type.id}</TD>
                        <c:url var="editUrl" value="/team/edit.html"><c:param name="id" value="${type.id}"/></c:url>
                        <TD><A href="${editUrl}">${type.name}</A></TD>
                        <TD><CODE>${type.manager}</CODE></TD>
                    </TR>
                </c:forEach>
            </TABLE>
            <c:url var="editUrl" value="/team/edit.html"/>
            <FORM action="${editUrl}">
                <BUTTON type="submit">Добавить проект</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>
