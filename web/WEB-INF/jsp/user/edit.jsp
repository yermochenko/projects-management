<%--
  Created by IntelliJ IDEA.
  User: Timofei
  Date: 08.06.2016
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>
<c:if test="${empty user}">
    <jsp:useBean id="user" class="by.vsu.mf.ammc.pm.domain.user.User"/>
</c:if>
<u:html title="Редактирование пользователя">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="userListUrl" value="/user/list.html"/>
    <c:url var="projectListUrl" value="/project/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${userListUrl}">Пользователи</A> ::
        Редактирование пользователя
    </DIV>
    <H2>Редактирование пользователя</H2>
    <DIV id="page">
        <DIV class="single-column">
            <H3>Редактирование пользователя ${user.lastName} ${user.firstName} ${user.middleName}</H3>
            <c:url var="userSaveUrl" value="/user/save.html"/>
            <FORM action="${userSaveUrl}" method="post">
                <c:if test="${not empty user.id}">
                    <INPUT type="hidden" name="id" value="${type.id}">
                </c:if>
                <LABEL for="name">Логин:</LABEL>
                <INPUT type="text" id="name" name="name" value="${user.name}">
                <LABEL for="password">Пароль:</LABEL>
                <INPUT type="password" id="password" name="password" value="${user.password}">
                <LABEL for="first_name">Имя пользователя:</LABEL>
                <INPUT type="text" id="first_name" name="first_name" value="${user.firstName}">
                <LABEL for="last_name">Фамилия</LABEL>
                <INPUT type="text" id="last_name" name="last_name" value="${user.lastName}">
                <LABEL for="middle_name">Отчество:</LABEL>
                <INPUT type="text" id="middle_name" name="middle_name" value="${user.middleName}">
                <LABEL for="group">Группа:</LABEL>
                <INPUT type="text" id="group" name="group" value="${user.group}">
                <BUTTON type="submit">Сохранить</BUTTON>
                <BUTTON type="reset">Очистить форму</BUTTON>
            </FORM>
            <c:url var="userDeleteUrl" value="/user/delete.html"/>
            <FORM action="${userDeleteUrl}">
                <BUTTON type="submit">Удалить</BUTTON>
            </FORM>
            <FORM action="${userListUrl}">
                <BUTTON type="submit">Отменить</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

