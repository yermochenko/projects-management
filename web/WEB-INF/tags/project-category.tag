<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="category" required="true" rtexprvalue="true" type="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${not empty category}">
	<UL class="nested">
		<c:forEach var="category" items="${category}">
			<c:url var="editUrl" value="/project-category/edit.html">
				<c:param name="id" value="${category.id}"/>
			</c:url>
			<LI><A href="${editUrl}">${group.name}</A>
				<u:user-group groups="${category.children}"/>
			</LI>
		</c:forEach>
	</UL>
</c:if>
