<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    Email: <input type="text" name="email" required /><br/>
    Password: <input type="password" name="password" required /><br/>
    <input type="submit" value="Login" />
</form>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body></html>
