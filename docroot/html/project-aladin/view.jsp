<%@include file="/html/project-aladin/init.jsp" %>

<c:choose>

	<c:when test="<%= themeDisplay.isSignedIn() %>">
		Benvenuto, <%= user.getScreenName() %>
		<liferay-util:include page="/html/project-aladin/main.jsp" servletContext="<%= pageContext.getServletContext() %>"/>
	</c:when>
	
	<c:otherwise>
		<liferay-util:include page="/html/project-aladin/login.jsp" servletContext="<%= pageContext.getServletContext() %>" />
	</c:otherwise>

</c:choose>