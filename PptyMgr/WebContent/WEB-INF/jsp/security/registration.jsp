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
		<form class="form-horizontal" name="registerForm" commandName="user" action="registerUser.auth" method='POST'>
			<fieldset>
			 <div class="control-group">
				<label class="control-label" for="focusedInput">First Name</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="firstName" name="firstName" type="text" value="">
				</div>
			  </div>							
			 <div class="control-group">
				<label class="control-label" for="middleName">Middle Name</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="middleName" name="middleName" type="text" value="">
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="lastName">Last Name</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="lastName" name="lastName" type="text" value="">
				</div>
			  </div>							  
			  <div class="control-group">
				<label class="control-label" for="username">Username</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="username" name="username" type="text" value="">
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="password" name="password" type="password" value="">				  
				</div>				
			  </div>
			  <div class="control-group">
				<label class="control-label" for="confirmPswd">Confirm password</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="confirmPswd" name="confirmPswd" type="password" value="">
				</div>
			  </div>							
			  <div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
				  <input class="span3 input-xlarge focused" id="email" name="email" type="text" value="">
				</div>
			  </div>
			  <div class="control-group">
			  <label class="control-label" for="mobile">Mobile</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="mobile" name="mobile" type="text" value="">
				</div>
			  </div>
			  <div class="control-group">
			  <label class="control-label" for="location">Location</label>
				<div class="controls">
				  <input class="span2 input-xlarge focused" id="location" name="location" type="text" value="">
				</div>
			  </div>							  
			  <div class="form-actions">
				<button type="submit" class="btn btn-primary">Register</button>
				<button class="btn">Cancel</button>
			  </div>
			</fieldset>
		  </form>					
	</div>
</body>
</html>