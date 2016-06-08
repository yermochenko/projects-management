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
<u:html title="Пользователи">
    <c:url var="mainUrl" value="/index.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Пользователи</DIV>
    <H2>Пользователи</H2>
    <DIV id="page">
        <DIV class="single-column">
            <H3>Список пользователей</H3>
            <TABLE>
                <TR>
                    <TH class="insignificant">id</TH>
                    <TH>Идентификатор пользователя</TH>
                    <TH>Имя пользователя</TH>
                </TR>
                <c:forEach var="type" items="${types}">
                    <TR>
                        <TD class="insignificant">${type.id}</TD>
                        <c:url var="editUrl" value="/user/edit.html"><c:param name="id" value="${type.id}"/></c:url>
                        <TD><A href="${editUrl}">${type.id}</A></TD>
                        <TD><CODE>${type.name}</CODE></TD>
                    </TR>
                </c:forEach>
            </TABLE>
            <c:url var="editUrl" value="/user/edit.html"/>
            <FORM action="${editUrl}">
                <BUTTON type="submit">Добавить пользователя</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

