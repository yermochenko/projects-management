<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="groups" required="true" rtexprvalue="true" type="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${not empty groups}">
	<UL class="nested">
		<c:forEach var="group" items="${groups}">
			<c:url var="editUrl" value="/users_group/edit.html">
				<c:param name="id" value="${group.id}"/>
			</c:url>
			<LI><A href="${editUrl}">${group.name}</A>
				<u:user-group groups="${group.children}"/>
			</LI>
		</c:forEach>
	</UL>
</c:if>
