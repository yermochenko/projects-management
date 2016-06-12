<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${empty category}">
    <jsp:useBean id="category" class="by.vsu.mf.ammc.pm.domain.project.management.TasksCategory"/>
</c:if>
<u:html title="Редактирование категорий заданий">
    <c:url var="mainUrl" value="/index.html"/>
    <c:url var="tasksCategoryListUrl" value="/tasks-category/list.html"/>
    <DIV id="breadcrumbs"><A href="${mainUrl}">Главная</A> :: <A href="${tasksCategoryListUrl}">Категории Заданий</A> :: Редактирование категорий заданий</DIV>
    <H2>Редактирование категорий заданий</H2>
    <DIV id="page">
        <DIV class="single-column">
            <c:choose>
                <c:when test="${not empty category.id}">
                    <H3>Категории заданий «${category.name}»</H3>
                </c:when>
                <c:otherwise>
                    <H3>Новая категория заданий</H3>
                </c:otherwise>
            </c:choose>
           <c:url var="tasksCategorySaveUrl" value="/tasks-category/save.html"/>
            <FORM action="${tasksCategorySaveUrl}" method="post">
                <c:if test="${not empty category.id}">
                    <INPUT type="hidden" name="id" value="${category.id}">
                </c:if>
                <LABEL for="category">Родительская категория:</LABEL>
                <SELECT id="category" name="parent_id">
                    <OPTION>&ndash;</OPTION>
                    <u:select-tasks-category categories="${categories}"/>
                </SELECT>
                <LABEL for="name">Категория задания:</LABEL>
                <INPUT type="name" id="name" name="name" value="${category.name}">
                <BUTTON type="submit">Сохранить</BUTTON>
                <BUTTON type="reset">Очистить форму</BUTTON>
            </FORM>
            <c:if test="${not empty category.id}">
                <c:url var="tasksCategoryDeleteUrl" value="/tasks-category/delete.html"/>
                <FORM action="${tasksCategoryDeleteUrl}" method="post">
                    <INPUT type="hidden" name="id" value="${category.id}">
                    <BUTTON type="submit">Удалить</BUTTON>
                </FORM>
            </c:if>
            <FORM action="${tasksCategoryListUrl}">
                <BUTTON type="submit">Отменить</BUTTON>
            </FORM>
        </DIV>
    </DIV>
</u:html>
