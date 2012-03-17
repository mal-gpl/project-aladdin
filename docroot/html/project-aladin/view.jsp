<%@include file="/html/project-aladin/init.jsp" %>

<c:choose>

	<c:when test="<%= themeDisplay.isSignedIn() %>">
		Benvenuto, <%= user.getScreenName() %>
	</c:when>
	
	<c:otherwise>
		<%-- TODO redirect to login page --%>
	</c:otherwise>

</c:choose>