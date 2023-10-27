package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.View.EducatorGUI;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Queue;

public class Content {

    private int id;
    private String title;
    private String comment;
    private String link;
    private String quiz;
    private Course course;

    public Content() {
    }

    public Content(int id, String title, String comment, String link, String quiz, int course_id) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.link = link;
        this.quiz = quiz;
        this.course = Course.getFetch(course_id);
    }


    public static ArrayList<Content> getContentForUser(int userId) {
        ArrayList<Content> contentList = new ArrayList<>();
        ArrayList<Integer> courseIds = getCourseIdsForUser(userId);
        for (int courseId : courseIds) {
            ArrayList<Content> contentsForCourse = getContentForCourse(courseId);
            contentList.addAll(contentsForCourse);
        }
        return contentList;
    }
    private static ArrayList<Integer> getCourseIdsForUser(int userId) {
        ArrayList<Integer> courseIds = new ArrayList<>();
        String query = "SELECT id FROM course WHERE user_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, userId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int courseId = rs.getInt("id");
                courseIds.add(courseId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courseIds;
    }
    public static ArrayList<Content> getContentForCourse(int courseId) {
        ArrayList<Content> contentList = new ArrayList<>();
        String query = "SELECT * FROM content WHERE course_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, courseId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String comment = rs.getString("comment");
                String link = rs.getString("link");
                String quiz = rs.getString("quiz");
                Content obj = new Content(id, title, comment, link, quiz, courseId);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contentList;
    }
    public static ArrayList<Content> allContents(){
        ArrayList<Content> contentList = new ArrayList<>();
        String query = "SELECT * FROM content";
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String comment = rs.getString("comment");
                String link = rs.getString("link");
                String quiz = rs.getString("quiz");
                int course_id = rs.getInt("course_id");
                Content obj = new Content(id, title, comment, link, quiz, course_id);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contentList;
    }
    public static Content getFetch(int id){
        Content obj = null;
        String query = "SELECT * FROM content WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Content(rs.getInt("id"), rs.getString("title"), rs.getString("comment"), rs.getString("link"), rs.getString("quiz"), rs.getInt("course_id") );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static ArrayList<Content> getListByContentId(int content_id){
        ArrayList<Content> contentList = new ArrayList<>();
        String query = "SELECT * FROM content WHERE id=?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int course_id = rs.getInt("course_id");
                String title = rs.getString("title");
                String comment = rs.getString("comment");
                String link = rs.getString("link");
                String quiz = rs.getString("quiz");
                Content obj = new Content(id, quiz, title, comment, link, course_id);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contentList;
    }
    public static boolean add(String title, String comment, String link, String quiz, int course_id){
        String query = "INSERT INTO content(title,comment,link,quiz,course_id) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, title);
            pr.setString(2, comment);
            pr.setString(3, link);
            pr.setString(4, quiz);
            pr.setInt(5, course_id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean delete(int content_id){
        String query = "DELETE FROM content WHERE id = ?";
        ArrayList<Content> contentList = Content.getListByContentId(content_id);
        for (Content c : contentList){
            Content.delete(c.getId());
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, content_id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean update(String title, String comment, String link, String quiz, int id){

        String query = "UPDATE content SET title = ?, comment = ?, link = ?, quiz = ? WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, title);
            pr.setString(2, comment);
            pr.setString(3, link);
            pr.setString(4, quiz);
            pr.setInt(5, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static String searchQuery(String title) {
        String query = "SELECT * FROM content WHERE title LIKE '%{{title}}%'";
        query = query.replace("{{title}}", title);
        return query;
    }

    public static ArrayList<Content> searchContentList(String query){
        ArrayList<Content> contentList = new ArrayList<>();
        Content obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setTitle(rs.getString("title"));
                obj.setComment(rs.getString("comment"));
                obj.setLink(rs.getString("link"));
                obj.setQuiz(rs.getString("quiz"));
                int course_id = rs.getInt("course_id");
                contentList.add(obj);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return contentList;
    }


// GETTER SETTER
public int getId() {
    return id;
}
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getQuiz() {
        return quiz;
    }
    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    // ## GETTER SETTER
}
