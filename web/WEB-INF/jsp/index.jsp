<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<u:html title="Главная">
	<DIV id="breadcrumbs">Главная</DIV>
	<H2>Главная страница пользователя</H2>
	<DIV id="page">
		<DIV class="single-column">
			<H3>В зависимости от роли пользователя</H3>
			<UL>
				<c:url var="url" value="/index.html">
					<c:param name="role" value="admin"/>
				</c:url>
				<LI><A href="${url}">Администратор</A></LI>
				<LI>Менеджер проекта</LI>
				<LI>Руководитель группы</LI>
				<LI>Бизнес-аналитик</LI>
				<LI>Разработчик</LI>
			</UL>
		</DIV>
	</DIV>
</u:html>
