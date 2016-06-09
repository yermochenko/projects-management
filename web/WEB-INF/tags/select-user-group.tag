<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="groups" required="true" rtexprvalue="true" type="java.util.List"%>
<%@attribute name="padding" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:forEach var="group" items="${groups}">
	<OPTION value="${group.id}">${padding}${group.name}</OPTION>
	<u:select-user-group groups="${group.children}" padding="${padding}&nbsp;&nbsp;&nbsp;&nbsp;"/>
</c:forEach>