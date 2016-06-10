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
<jsp:useBean id="team" class="by.vsu.mf.ammc.pm.domain.project.management.Team"/>

<u:html title="Редактирование команды проекта">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="teamListUrl" value="/manager/team/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${teamListUrl}">Команды проектов</A> :: Редактирование команды проектов</DIV>
    <H2>Редактирование команды проектов</H2>
    <DIV id="content">
         <DIV id="page">
            <DIV class="single-column">
                <c:url var="teamUrl" value="/manager/team/list.html"><c:param name="team-id" value="${team.id}"/></c:url>
                <H3>Редактирование команды ведущего программиста ${team.leader.lastName}&nbsp;${fn:substring(team.leader.firstName,0,1)}.&nbsp;${fn:substring(team.leader.middleName,0,1)} на проекте «ОАО «Рога и копыта»»</H3>
                <c:url var="teamSaveUrl" value="/manager/team/save.html"/>
                <FORM action="${teamSaveUrl}" method="post">
                    <c:if test="${not empty team}">
                        <INPUT type="hidden" name="id" value="${team.id}">
                    </c:if>
                    <LABEL for="lead">Ведущий программист команды:</LABEL>
                    <SELECT id="lead">
                        <c:forEach var="user" items="${users}">
                            <c:choose>
                                <c:when test="${not empty team and user.id == team.leader.id}">
                                    <c:set var="selected" value=" selected"/>
                                </c:when>
                                <c:otherwise>
                                    <c:remove var="selected"/>
                                </c:otherwise>
                            </c:choose>
                            <OPTION value="${user.id}"${selected}>${user.lastName}&nbsp;${fn:substring(user.firstName,0,1)}.&nbsp;${fn:substring(user.middleName,0,1)}.</OPTION>
                        </c:forEach>
                    </SELECT>
                    <BUTTON type="submit">Сохранить</BUTTON>
                    <BUTTON type="reset">Очистить форму</BUTTON>
                </FORM>
                <c:if test="${not empty team}">
                    <FORM action="${teamDeleteUrl}">
                        <INPUT type="hidden" name="id" value="${team.id}">
                        <BUTTON type="submit">Удалить</BUTTON>
                    </FORM>
                </c:if>
                <c:url var="teamDeleteUrl" value="/manager/team/delete.html"/>
                <FORM action="${teamUrl}">
                    <BUTTON type="submit">Отменить</BUTTON>
                </FORM>
            </DIV>
        </DIV>

    </DIV>




</u:html>

