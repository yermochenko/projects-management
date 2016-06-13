<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="entities" required="true" rtexprvalue="true" type="java.util.List"%>
<%@attribute name="padding" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="id" required="false" rtexprvalue="true" type="java.lang.Integer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:forEach var="entity" items="${entities}">
	<c:choose>
		<c:when test="${not empty id and entity.id == id}">
			<c:set var="selected" value=" selected"/>
		</c:when>
		<c:otherwise>
			<c:remove var="selected"/>
		</c:otherwise>
	</c:choose>
	<OPTION value="${entity.id}"${selected}>${padding}${entity.name}</OPTION>
	<u:select-hierarchy entities="${entity.children}" padding="${padding}&nbsp;&nbsp;&nbsp;&nbsp;" id="${id}"/>
</c:forEach>