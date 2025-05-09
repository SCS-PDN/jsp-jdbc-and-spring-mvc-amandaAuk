public class LoginController {

    
    private JdbcTemplate jdbcTemplate;

    ("/login")
    public String showLoginForm() {
        return "login";
    }

    ("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
        try {
            Map<String, Object> user = jdbcTemplate.queryForMap(sql, email, password);
            session.setAttribute("studentId", user.get("student_id"));
            session.setAttribute("studentName", user.get("name"));
            return "redirect:/courses";
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }

    ("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
