<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div class="errorMessage" style="padding-left: 8px;">
		<c:out value="${message}" />
	</div>
	<div class="box-content">
		<form:form name="registerForm" commandName="user" action="registerUser.auth" method='POST'>		
			<div class="form-horizontal">
			<fieldset>			
			 <div class="control-group">
				<label class="control-label" for="focusedInput">First Name</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="firstName" name="firstName" type="text" value="${user.firstName}">				  
				  <span class="help-inline"><form:errors path="firstName" /></span>				  
				</div>
			  </div>
			  							
			 <div class="control-group">
				<label class="control-label" for="middleName">Middle Name</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="middleName" name="middleName" type="text" value="${user.middleName}">
				  <span class="help-inline"><form:errors path="middleName" /></span>
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="lastName">Last Name</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="lastName" name="lastName" type="text" value="${user.lastName}">
				  <span class="help-inline"><form:errors path="lastName" /></span>
				</div>
			  </div>							  
			  <div class="control-group">
				<label class="control-label" for="username">Username</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="username" name="username" type="text" value="${user.username}">
				  <span class="help-inline"><form:errors path="username" /></span>
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="password" name="password" type="password" value="">	
				  <span class="help-inline"><form:errors path="password" /></span>			  
				</div>				
			  </div>
			  <div class="control-group">
				<label class="control-label" for="confirmPswd">Confirm password</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="confirmPswd" name="confirmPswd" type="password" value="">
				  <span class="help-inline"><form:errors path="confirmPswd" /></span>
				</div>
			  </div>							
			  <div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="email" name="email" type="text" value="${user.email}">
				  <span class="help-inline"><form:errors path="email" /></span>
				</div>
			  </div>
			  <div class="control-group">
			  <label class="control-label" for="mobile">Mobile +91 </label>
				<div class="controls">
				  <input class="input-xlarge focused" id="mobile" name="mobile" type="text" value="${user.mobile}">
				  <span class="help-inline"><form:errors path="mobile" /></span>
				</div>
			  </div>
			  <div class="control-group">
			  <label class="control-label" for="location">City</label>
				<div class="controls">
				  <input class="input-xlarge focused" id="location" name="location" type="text" value="${user.location}">
				  <span class="help-inline"><form:errors path="location" /></span>
				</div>
			  </div>							  
			  <div class="form-actions">
				<button type="submit" class="btn btn-primary">Register</button>
				<button class="btn">Cancel</button>
			  </div>
			</fieldset>
			</div>			
		  </form:form>		  					
	</div>	
</body>
</html>