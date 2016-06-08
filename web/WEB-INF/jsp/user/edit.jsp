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
    <jsp:useBean id="type" class="by.vsu.mf.ammc.pm.domain.user.User"/>
</c:if>
<u:html title="Редактирование пользователь">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="userListUrl" value="/user/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${userListUrl}">Пользователь</A> :: Редактирование пользователь</DIV>
    <H2>Редактирование пользователей</H2>
    <DIV id="page">
        <DIV class="single-column">
            <c:choose>
                <c:when test="${not empty type.id}">
                    <H3>пользователь «${type.name}»</H3>
                </c:when>
                <c:otherwise>
                    <H3>Новый пользователь</H3>
                </c:otherwise>
            </c:choose>
            <c:url var="userSaveUrl" value="/user/save.html"/>
            <FORM action="${userSaveUrl}" method="post">
                <c:if test="${not empty type.id}">
                    <INPUT type="hidden" name="id" value="${type.id}">
                </c:if>
                <LABEL for="id">Пользователь:</LABEL>
                <INPUT type="id" id="id" name="id" value="${type.id}">
                <LABEL for="user_id">Идентификатор проекта:</LABEL>
                <INPUT type="user_id" id="user_id" name="user_id" value="${type.user_id}">
                <BUTTON type="submit">Сохранить</BUTTON>
                <BUTTON type="reset">Очистить форму</BUTTON>
            </FORM>
            <c:if test="${not empty type.id}">
                <c:url var="userDeleteUrl" value="/user/delete.html"/>
                <FORM action="${userDeleteUrl}" method="post">
                    <INPUT type="hidden" name="id" value="${type.id}">
                    <BUTTON type="submit">Удалить</BUTTON>
                </FORM>
            </c:if>
            <FORM action="${userListUrl}">
                <BUTTON type="submit">Отменить</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

