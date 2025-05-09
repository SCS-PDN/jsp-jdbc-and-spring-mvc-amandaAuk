
public class CourseController {

    
    private JdbcTemplate jdbcTemplate;

    ("/courses")
    public String listCourses(Model model) {
        List<Map<String, Object>> courses = jdbcTemplate.queryForList("SELECT * FROM courses");
        model.addAttribute("courses", courses);
        return "courses";
    }

    ("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId, HttpSession session, Model model) {
        Object studentId = session.getAttribute("studentId");
        if (studentId == null) {
            return "redirect:/login";
        }

        // Prevent duplicate registration
        String checkSql = "SELECT COUNT(*) FROM registrations WHERE student_id = ? AND course_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, studentId, courseId);
        if (count == 0) {
            String sql = "INSERT INTO registrations (student_id, course_id) VALUES (?, ?)";
            jdbcTemplate.update(sql, studentId, courseId);
        }

        return "success";
    }
}
