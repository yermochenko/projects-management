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
<u:html title="Группы пользователей">
    <c:url var="mainUrl" value="/index.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Группы пользователей</DIV>
    <H2>Группы пользователей</H2>
    <DIV id="page">
        <DIV class="single-column">
            <H3>Список групп пользователей</H3>
            <u:user-group groups="${types}"/>
            <c:url var="editUrl" value="/users_group/edit.html"/>
            <FORM action="${editUrl}">
                <BUTTON type="submit">Добавить группу пользователей</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

