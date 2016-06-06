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
		</DIV>
		<DIV id="wrapper">
			<DIV id="content">
				<jsp:doBody/>
				<DIV id="copyright">&copy; Лаборатория компьютерных технологий ВГУ имени П.&nbsp;М.&nbsp;Машерова</DIV>
			</DIV>
		</DIV>
	</BODY>
</HTML>