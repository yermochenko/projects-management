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
<u:html title="Команды проектов">
    <c:url var="mainUrl" value="/index.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Команды проектов</DIV>
    <H2>Команды проектов</H2>
    <DIV id="page">
        <DIV class="single-column">
            <H3>Список команд проектов</H3>
            <TABLE>
                <TR>
                    <TH class="insignificant">id</TH>
                    <TH>Идентификатор проекта</TH>
                    <TH>Идентификатор лидера</TH>
                </TR>
                <c:forEach var="type" items="${types}">
                    <TR>
                        <TD class="insignificant">${type.id}</TD>
                        <c:url var="editUrl" value="/team/edit.html"><c:param name="id" value="${type.id}"/></c:url>
                        <TD><A href="${editUrl}">${type.name}</A></TD>
                        <TD><CODE>${type.regexp}</CODE></TD>
                    </TR>
                </c:forEach>
            </TABLE>
            <c:url var="editUrl" value="/team/edit.html"/>
            <FORM action="${editUrl}">
                <BUTTON type="submit">Добавить команду проекта</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

