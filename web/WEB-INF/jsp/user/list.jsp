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
<c:if test="${empty type}">
    <jsp:useBean id="userType" class="by.vsu.mf.ammc.pm.domain.user.User"/>
</c:if>
<c:if test="${empty type}">
    <jsp:useBean id="userGroupType" class="by.vsu.mf.ammc.pm.domain.user.UsersGroup"/>
</c:if>
<u:html title="Пользователи">
    <c:url var="mainUrl" value="/index.html"/>

    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: Пользователи</DIV>
    <H2>Пользователи</H2>
    <DIV id="page">
        <DIV class="main-column">
            <H3>Пользователи группы ${userGroupType.name}</H3>
            <TABLE>
                <TR>
                    <TH class="insignificant">№</TH>
                    <TH>Псевдоним</TH>
                    <TH>Фамилия</TH>
                    <TH>Имя</TH>
                    <TH>Отчество</TH>
                </TR>
                <c:forEach var="user" items="${users}">
                    <c:url var="userUrl" value="/user/list.html">
                        <c:param name="user-id" value="${user.id}"/>
                    </c:url>
                    <TR>
                        <TD class="insignificant">${user.id}</TD>
                        <TD><A href="${userUrl}">${user.name}</A></TD>
                        <TD>${user.firstName}</TD>
                        <TD>${user.lastName}</TD>
                        <TD>${user.middleName}</TD>
                    </TR>
                </c:forEach>
            </TABLE>
            <c:url var="userSaveUrl" value="/user/save.html"/>
            <FORM action="${userSaveUrl}">
                <BUTTON type="submit">Добавить пользователя</BUTTON>
            </FORM>
        </DIV>
        <DIV class="side-column">
            <H3>Группы пользователей</H3>
            <UL>
                <c:forEach var="usersGroup" items="${usersGroups}">
                    <c:url var="usersGroupUrl" value="/users_group/list.html">
                        <c:param name="usersGroup-id" value="${usersGroup.id}"/>
                    </c:url>
                    <LI><A href="${usersGroupUrl}?id=${usersGroup.id}">${usersGroup.name}</A></LI>
                </c:forEach>
            </UL>
            <c:url var="userGroupListUrl" value="/users_group/list.html"/>
            <FORM action="${userGroupListUrl}">
                <BUTTON type="submit">Редактировать группы</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>

