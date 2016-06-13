<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="entities" required="true" rtexprvalue="true" type="java.util.List"%>
<%@attribute name="url" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="idparam" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<c:forEach var="entity" items="${entities}">
	<LI>
		<c:choose>
			<c:when test="${not empty url}">
				<c:url var="entityUrl" value="${url}">
					<c:choose>
						<c:when test="${not empty idparam}">
							<c:param name="${idparam}" value="${entity.id}"/>
						</c:when>
						<c:otherwise>
							<c:param name="id" value="${entity.id}"/>
						</c:otherwise>
					</c:choose>
				</c:url>
				<A href="${entityUrl}">${entity.name}</A>
			</c:when>
			<c:otherwise>${entity.name}</c:otherwise>
		</c:choose>
		<c:if test="${not empty entity.children}">
			<UL class="nested">
				<u:hierarchy entities="${entity.children}" url="${url}" idparam="${idparam}"/>
			</UL>
		</c:if>
	</LI>
</c:forEach>