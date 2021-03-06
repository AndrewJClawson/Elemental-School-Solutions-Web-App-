<%-- 
    Document   : login
    Created on : Apr 20, 2016, 1:46:30 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="/resources/foundation/css/foundation.css"/>
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <!-- Header -->
        <div class="row" style="height:200px; width:100%">
            <div class="large-12 columns" align="center">
            
                <jsp:include page="/WEB-INF/jsp/tiles/header.jsp"/>
            </div>
            
        </div>
        
        
        <!-- Content -->
        <div class="row" style="height:300px" >
            <div class="large-4 columns">
                <jsp:include page="/WEB-INF/jsp/tiles/login_menu.jsp"/>
            </div>
            <div class="large-8 columns">
                
            </div>
        </div>
        
        <!-- Footer -->
        <div>
            
        </div>
        
    </body>
</html>
