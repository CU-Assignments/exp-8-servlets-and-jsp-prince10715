CREATE TABLE attendance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(50),
    date DATE,
    status VARCHAR(10)
);
#attendance
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h2>Enter Attendance Details</h2>
    <form action="AttendanceServlet" method="post">
        <label>Student Name:</label>
        <input type="text" name="student_name" required><br>
        <label>Date:</label>
        <input type="date" name="date" required><br>
        <label>Status:</label>
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>

AttendanceServlet

#<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2>Attendance Recorded Successfully!</h2>
    <a href="attendance.jsp">Back to Form</a>
</body>
</html>
