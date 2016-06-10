<%--
  Created by IntelliJ IDEA.
  User: Timofei
  Date: 08.06.2016
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Команды проектов">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="projectUrl" value="/project/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectUrl}">Проекты</A> :: Сотрудники</DIV>
    <H2>Сотрудники</H2>
    <DIV id="page">
        <DIV class="main-column">
            <H3>Выберите команду</H3>
        </DIV>
        <DIV class="side-column">
            <H3>Команды проекта</H3>
            <P>Ведущие программисты команд</P>
            <UL>
                <c:forEach var="team" items="${teams}">
                    <c:url var="teamUrl" value="/manager/team/list.html">
                        <c:param name="team-id" value="${team.id}"/>
                    </c:url>
                    <LI><A href="${teamUrl}">${team.leader.lastName}&nbsp;${fn:substring(team.leader.firstName,0,1)}.&nbsp;${fn:substring(team.leader.middleName,0,1)}.</A></LI>
                </c:forEach>
            </UL>
            <c:url var="editTeamsUrl" value="/manager/team/list2.html"/>
            <FORM action="${editTeamsUrl}">
                <INPUT type="hidden" name="id" value="${param['id']}">
                <BUTTON type="submit">Редактировать команды</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

