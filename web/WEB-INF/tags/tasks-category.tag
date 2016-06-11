<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="categories" required="true" rtexprvalue="true" type="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:if test="${not empty categories}">
	<UL class="nested">
		<c:forEach var="category" items="${categories}">
			<c:url var="editUrl" value="/tasks-category/edit.html">
				<c:param name="id" value="${category.id}"/>
			</c:url>
			<LI><A href="${editUrl}">${category.name}</A>
				<u:tasks-category categories="${category.children}"/>
			</LI>
		</c:forEach>
	</UL>
</c:if>
