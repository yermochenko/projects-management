<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="category" required="true" rtexprvalue="true" type="java.util.List"%>
<%@attribute name="padding" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:forEach var="category1" items="${category}">
	<OPTION value="${category1.id}">${padding}${category.name}</OPTION>
	<u:select-tasks-category categories="${category1.children}" padding="${padding}&nbsp;&nbsp;&nbsp;&nbsp;"/>
</c:forEach>