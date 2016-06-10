<%--
  Created by IntelliJ IDEA.
  User: Timofei
  Date: 10.06.2016
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>
<u:html title="Команды проектов">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="projectUrl" value="/project/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectUrl}">Проекты</A> :: Сотрудники</DIV>
    <H2>Команды проекта</H2>
    <DIV id="page">
        <DIV class="single-column">
            <H3>Список команд проекта «ОАО «Рога и копыта»»</H3>
            <P>Ведущие программисты команд</P>
            <UL>
                <c:forEach var="team" items="${teams}">
                    <c:url var="teamUrl" value="/manager/team/edit.html">
                        <c:param name="id" value="${team.id}"/>
                    </c:url>
                    <LI><A href="${teamUrl}">${team.leader.lastName}&nbsp;${fn:substring(team.leader.firstName,0,1)}.&nbsp;${fn:substring(team.leader.middleName,0,1)}.</A></LI>
                </c:forEach>
            </UL>
            <c:url var="saveTeamUrl" value="/manager/team/edit.html"/>
            <FORM action="${saveTeamUrl}">
                <BUTTON type="submit">Добавить команду на проект</BUTTON>
            </FORM>
            <c:url var="listEmployeeUrl" value="/manager/team/list.html"/>
            <FORM action="${listEmployeeUrl}">
                <INPUT type="hidden" name="id" value="${param['id']}">
                <BUTTON type="submit">Закончить редактирование команд</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>