public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        HttpSession session = request.getSession(false);
        String user = (session != null && session.getAttribute("studentId") != null)
                        ? session.getAttribute("studentName").toString()
                        : "Anonymous";

        if (uri.contains("/login") && method.equals("POST")) {
            System.out.println("Login attempt by: " + request.getParameter("email"));
        } else if (uri.contains("/register/") && method.equals("POST")) {
            System.out.println("Registration attempt by " + user + " to course " + uri);
        }

        return true;
    }
}
