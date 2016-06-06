<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<HTML>
	<HEAD>
		<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<TITLE>Управление проектами - ${title}</TITLE>
		<c:url var="cssUrl" value="/main.css"/>
		<LINK rel="stylesheet" type="text/css" href="${cssUrl}">
	</HEAD>
	<BODY>
		<DIV id="header">
			<H1>Управление<BR>Проектами</H1>
			<c:if test="${not empty menu}">
				<UL class="right">
					<c:forEach var="menuItem" items="${menu}">
						<c:url var="menuUrl" value="${menuItem.url}"/>
						<c:choose>
							<c:when test="${menuUrl == requestScope['javax.servlet.forward.request_uri']}">
								<LI class="item"><A href="${menuUrl}" class="current">${menuItem.title}</A></LI>
							</c:when>
							<c:otherwise>
								<LI class="item"><A href="${menuUrl}">${menuItem.title}</A></LI>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</UL>
			</c:if>
		</DIV>
		<DIV id="wrapper">
			<DIV id="content">
				<jsp:doBody/>
				<DIV id="copyright">&copy; Лаборатория компьютерных технологий ВГУ имени П.&nbsp;М.&nbsp;Машерова</DIV>
			</DIV>
		</DIV>
	</BODY>
</HTML>