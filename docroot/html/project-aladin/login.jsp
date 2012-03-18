<%@include file="/html/project-aladin/init.jsp" %>

<portlet:actionURL name="login" var="loginURL" />

<div id="<portlet:namespace />login">

	<aui:form
		name="loginFm"
		cssClass="login-form"
		method="post"
		action="<%= loginURL.toString() %>"
	>
		<aui:fieldset>
			<aui:input
				label="login-username"
				name="<%= CoreControllerConstants.USERNAME %>"
				type="text"
				inlineField="false"
				inlineLabel="left"
			/>
			
			<aui:input
				label="login-password"
				name="<%= CoreControllerConstants.PASSWORD %>"
				type="password"
				inlineField="false"
				inlineLabel="left"
			/>
	
			<aui:button
				type="submit"
				value="login-submit"
			/>		
		</aui:fieldset>
	
	</aui:form>

</div>