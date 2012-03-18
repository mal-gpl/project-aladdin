<%@include file="/html/project-aladin/init.jsp" %>

<div id="<portlet:namespace />dashboard">

	<div class="news"></div>
	
	<div class="wishNavigator">
	
		<div class="wishlistHeader">
			Last wishes:
			<aui:button
				href="#"
				value="Vai alla wishlist" 
				inputCssClass="go-to-wishlist button">
			</aui:button>
		</div>
		<br />
		
		<hr />
		
		<div class="wishes">
			<%-- 
				Qui andrà un elenco dei wish più recenti 
				associati all'utente
			--%>
			<ul id="<portlet:namespace />wishes-listing" class="wishes-list">
				<li class="wish">
					Wish 1
				</li>
				<li class="wish">
					Wish 2
				</li>
				<li class="wish">
					Wish 3
				</li>
			</ul>
		</div>
		
	</div>

</div>
