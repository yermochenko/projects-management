<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="value" required="true" rtexprvalue="true" type="by.vsu.mf.ammc.pm.domain.user.User"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
${value.lastName}&nbsp;${fn:substring(value.firstName, 0, 1)}.&nbsp;${fn:substring(value.middleName, 0, 1)}.