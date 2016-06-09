<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 08.06.2016
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty type}">
    <jsp:useBean id="type" class="by.vsu.mf.ammc.pm.domain.user.UsersGroup"/>
</c:if>
<u:html title="Редактирование группы пользователей">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="users_groupListUrl" value="/users_group/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${usersGroupListUrl}">Группы пользователей</A> :: Редактирование группы пользователей</DIV>
    <H2>Редактирование группы пользователей</H2>
    <DIV id="page">
        <DIV class="single-column">
            <c:choose>
                <c:when test="${not empty type.id}">
                    <H3>Группа пользователей «${type.name}»</H3>
                </c:when>
                <c:otherwise>
                    <H3>Новая группа пользователей</H3>
                </c:otherwise>
            </c:choose>
            <c:url var="users_groupSaveUrl" value="/users_group/save.html"/>
            <FORM action="${users_groupSaveUrl}" method="post">
                <c:if test="${not empty type.id}">
                    <INPUT type="hidden" name="id" value="${type.id}">
                </c:if>
                <LABEL for="group">Родительская группа:</LABEL>
                <SELECT id="group" name="parent_id">
                    <OPTION>&ndash;</OPTION>
                    <u:select-user-group groups="${groups}"/>
                </SELECT>
                <LABEL for="name">Имя группы пользователей:</LABEL>
                <INPUT type="name" id="name" name="name" value="${type.name}">
                <BUTTON type="submit">Сохранить</BUTTON>
                <BUTTON type="reset">Очистить форму</BUTTON>
            </FORM>
            <c:if test="${not empty type.id}">
                <c:url var="users_groupDeleteUrl" value="/users_group/delete.html"/>
                <FORM action="${users_groupDeleteUrl}" method="post">
                    <INPUT type="hidden" name="id" value="${type.id}">
                    <BUTTON type="submit">Удалить</BUTTON>
                </FORM>
            </c:if>
            <FORM action="${users_groupListUrl}">
                <BUTTON type="submit">Отменить</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

