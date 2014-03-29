<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.getElementById("j_username").focus();'>
<script type="text/javascript">
function submitForm(){
	//alert("logging in");
document.forms[0].action='j_spring_security_check';
document.forms[0].submit();
};
function registerUser(){
	//alert("registering");
document.forms[0].action='register.auth';
document.forms[0].submit();
}
</script>	
 
	<%-- <c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<c:if test="${param.error == 'true'}">
    	<span>Invalid login please check username and password...</span>
	</c:if> --%>

			<div class="row-fluid">
				<div class="well span5 center">
				<c:if test="${param.error == 'true'}">
					<div class="control-group error">						
						<div class="controls">						  
						  <span class="help-inline">Invalid login please check username and password...</span>
						</div>
					  </div>
				</c:if>
					<div class="alert alert-info">
						Please login with your Username and Password.
					</div>
					<form name='loginForm' action="" class="form-horizontal" action=""	method='POST'>
						<fieldset>
							<div class="input-prepend" title="Username" data-rel="tooltip">
								<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="j_username" id="j_username" type="text" value="" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password" data-rel="tooltip">
								<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="j_password" id="j_password" type="password" value="" />
							</div>
							<div class="clearfix"></div>

							<!-- <div class="input-prepend">
							<label class="remember" for="remember"><input type="checkbox" id="remember" />Remember me</label>
							</div> -->
							<div class="clearfix"></div>	
							<div class="box-content">
								  <button id="login1" onclick="submitForm();" type="submit" class="btn btn-large btn-primary btn-round">Submit</button>
								  <button  id="reset1"  type="reset" class="btn btn-large btn-primary btn-round">Reset</button>
								  <button id="register1" onclick="registerUser();" type="submit" class="btn btn-large btn-primary btn-round">Register</button>
							</div>						
						</fieldset>
					</form>
				</div><!--/span-->					
			</div><!--/row-->

</body>
</html>

