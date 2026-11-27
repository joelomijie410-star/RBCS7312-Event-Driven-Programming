package com.university;

import java.sql.*;
import java.util.*;

/** Small JDBC repository. Connection values come from environment variables, never source code. */
public final class Database {
    private Database() {}
    private static String url(){ return System.getenv().getOrDefault("RBCS_DB_URL", "jdbc:mysql://localhost:3306/university_db?serverTimezone=UTC"); }
    private static String user(){ return System.getenv().getOrDefault("RBCS_DB_USER", "root"); }
    private static String password(){ return System.getenv().getOrDefault("RBCS_DB_PASSWORD", ""); }
    private static Connection connect() throws SQLException { return DriverManager.getConnection(url(), user(), password()); }
    public static List<Student> load() throws SQLException {
        String sql="SELECT student_id, registration_number, first_name, last_name, email FROM students ORDER BY student_id";
        try(Connection c=connect(); PreparedStatement p=c.prepareStatement(sql); ResultSet r=p.executeQuery()) {
            List<Student> result=new ArrayList<>(); while(r.next()) result.add(new Student(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5))); return result;
        }
    }
    public static void insert(String reg,String first,String last,String email) throws SQLException {
        String sql="INSERT INTO students(registration_number,first_name,last_name,email) VALUES(?,?,?,?)";
        try(Connection c=connect(); PreparedStatement p=c.prepareStatement(sql)) {
            p.setString(1,reg); p.setString(2,first); p.setString(3,last); p.setString(4,email); p.executeUpdate();
        }
    }
}
