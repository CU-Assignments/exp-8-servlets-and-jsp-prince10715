CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    department VARCHAR(50)
);
INSERT INTO employees (name, department) VALUES 
('John Doe', 'IT'), 
('Jane Smith', 'HR');

#EmployeeServlet
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            
            out.println("<h2>Employee List</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Department</th></tr>");
            while(rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td></tr>");
            }
            out.println("</table>");
            
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}

#employee
<%@ page import="java.sql.*" %>
<html>
<head><title>Employee List</title></head>
<body>
    <h2>Employees</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Department</th></tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
                
                while(rs.next()) {
        %>
                <tr><td><%= rs.getInt(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td></tr>
        <%
                }
                con.close();
            } catch(Exception e) {
                out.println("<h3>Error: " + e.getMessage() + "</h3>");
            }
        %>
    </table>
</body>
</html>
