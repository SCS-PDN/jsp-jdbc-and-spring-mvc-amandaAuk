<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Available Courses</h2>
<c:forEach var="course" items="${courses}">
    <p>
        <b>${course.name}</b> - ${course.instructor} (${course.credits} credits)
        <form method="post" action="${pageContext.request.contextPath}/register/${course.course_id}">
            <input type="submit" value="Register" />
        </form>
    </p>
</c:forEach>
</body></html>
