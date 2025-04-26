package name;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class Scheduler(){
    private DatabaseManager dbManager;
    private List<Course> courses;

    public Scheduler() {
        this.dbManager = new DatabaseManager();
        courses = new ArrayList<>();
    }
    
    public Scheduler(DatabaseManager dbManager) {
        this.dbManager = dbManager;
        courses = new ArrayList<>();
    }
   
    public List<Course> searchCourse(String query) {
        List<Course> results = new ArrayList<>();
        try {
            dbManager.connection();
            String stmt = "SELECT * FROM courses WHERE name LIKE '%" + query + "%'";
            ResultSet rs = dbManager.executeQuery(stmt);
            while (rs.next()) {
                String courseName = rs.getString("name");
                int courseId = rs.getInt("id");
                results.add(new Course(courseName, courseId));
            }
            dbManager.disconnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public boolean joinCourse(int courseId, String userId) {
        boolean success = false;
        try {
            Connection conn = dbManager.connection();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO user_courses (user_id, course_id) VALUES (?, ?)"
            );
            stmt.setString(1, userId);
            stmt.setInt(2, courseId);

            success = stmt.executeUpdate() > 0;
            
            dbManager.disconnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean createCourse(String courseName, String date, String time) {
    // keep or note?  String date, String time
    }

}

