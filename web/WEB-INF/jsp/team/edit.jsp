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
<c:if test="${empty type}">
    <jsp:useBean id="type" class="by.vsu.mf.ammc.pm.domain.project.management.Team"/>
</c:if>
<u:html title="Редактирование команды проектов">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="projectListUrl" value="/contacts-type/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${projectListUrl}">Команды проектов</A> :: Редактирование команды проектов</DIV>
    <H2>Редактирование команды проектов</H2>
    <DIV id="page">
        <DIV class="single-column">
            <c:choose>
                <c:when test="${not empty type.id}">
                    <H3>команда проектов «${type.name}»</H3>
                </c:when>
                <c:otherwise>
                    <H3>Новая команда проектов</H3>
                </c:otherwise>
            </c:choose>
            <c:url var="teamSaveUrl" value="/team/save.html"/>
            <FORM action="${teamSaveUrl}" method="post">
                <c:if test="${not empty type.id}">
                    <INPUT type="hidden" name="id" value="${type.id}">
                </c:if>
                <LABEL for="id">Команда:</LABEL>
                <INPUT type="id" id="id" name="id" value="${type.id}">
                <LABEL for="project_id">Идентификатор проекта:</LABEL>
                <INPUT type="project_id" id="project_id" name="project_id" value="${type.project_id}">
                <BUTTON type="submit">Сохранить</BUTTON>
                <BUTTON type="reset">Очистить форму</BUTTON>
            </FORM>
            <c:if test="${not empty type.id}">
                <c:url var="tamDeleteUrl" value="/team/delete.html"/>
                <FORM action="${teamDeleteUrl}" method="post">
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

