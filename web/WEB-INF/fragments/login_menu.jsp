<%-- 
    Document   : login_menu
    Created on : Apr 9, 2016, 9:40:16 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app" %>

<!DOCTYPE html>
<html>
    
    <div class='side_menu'>
        
        <h2>Login</h2>
        <form:form id="loginForm" action="${pageContext.request.contextPath}/dashboard.htm">
            <table>
                <tr>
                    <td><b>Email: </td>
                    <td><input id="loginEmail" name="email" type="text"/></td>
                </tr>
                <tr>
                    <td><b>Password: </td>
                    <td><input id="loginPassword" name="password" type="password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a class="button" onclick="ValidateLoginForm();">Login</a></td>
                </tr>
                   
            </table>
            
        </form:form>
        Click <a href="${pageContext.request.contextPath}/subscribe.htm">here</a> to submit a registration request to subscribe to <app:AppName/>.<br>
    </div>
    <script src="js/login.js"></script>
</html>

