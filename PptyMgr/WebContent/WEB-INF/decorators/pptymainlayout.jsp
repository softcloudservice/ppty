<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Propmanager - Complete property management software</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<jsp:include flush="true" page="/WEB-INF/decorators/commons.jsp"></jsp:include>	
	<!-- <decorator:head/> -->
</head>

<body>

	<jsp:include flush="true" page="/WEB-INF/decorators/header.jsp"></jsp:include>
	<div id="content">	
        <decorator:body/>
    </div>
    <jsp:include flush="true" page="/WEB-INF/decorators/footer.jsp"></jsp:include>	
		
</body>
</html>
