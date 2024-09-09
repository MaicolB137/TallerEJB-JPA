<%-- 
    Document   : studentInfo
    Created on : 5/09/2024, 09:36:16 PM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student and Course Management</title>
</head>
<body>
<h1>Student and Course Management</h1>

<!-- Formulario para gestionar estudiantes -->
<h2>Manage Students</h2>
<form action="./StudentServlet" method="POST">
    <table>
        <tr>
            <td>Student Id</td>
            <td><input type="text" name="studentId" value="${student.studentid}" /></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" value="${student.firstname}" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" value="${student.lastname}" /></td>
        </tr>
        <tr>
            <td>Year Level</td>
            <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete" />
                <input type="submit" name="action" value="Search" />
            </td>
        </tr>
    </table>
</form>

<!-- Mostrar tabla de estudiantes -->
<h3>Student List</h3>
<table border="1">
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Year Level</th>
    <c:forEach items="${allStudents}" var="stud">
        <tr>
            <td>${stud.studentid}</td>
            <td>${stud.firstname}</td>
            <td>${stud.lastname}</td>
            <td>${stud.yearlevel}</td>
        </tr>
    </c:forEach>
</table>

<hr/>

<!-- Formulario para gestionar cursos -->
<h2>Manage Courses</h2>
<form action="./CursoServlet" method="POST">
    <table>
        <tr>
            <td>Codigo Curso</td>
            <td><input type="text" name="codigoCurso" value="${curso.codigoCurso}" /></td>
        </tr>
        <tr>
            <td>Nombre Curso</td>
            <td><input type="text" name="nombreCurso" value="${curso.nombreCurso}" /></td>
        </tr>
        <tr>
            <td>Numero Creditos</td>
            <td><input type="text" name="numeroCreditos" value="${curso.numeroCreditos}" /></td>
        </tr>
        <tr>
            <td>Semestre</td>
            <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
        </tr>
        <tr>
            <td>Max Students</td>
            <td><input type="text" name="numeroEstudiantesAdmitidos" value="${curso.numeroEstudiantesAdmitidos}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete" />
                <input type="submit" name="action" value="Search" />
            </td>
        </tr>
    </table>
</form>

<!-- Mostrar tabla de cursos -->
<h3>Course List</h3>
<table border="1">
    <th>Course Code</th>
    <th>Course Name</th>
    <th>Credits</th>
    <th>Semester</th>
    <th>Max Students</th>
    <c:forEach items="${allCursos}" var="curso">
        <tr>
            <td>${curso.codigoCurso}</td>
            <td>${curso.nombreCurso}</td>
            <td>${curso.numeroCreditos}</td>
            <td>${curso.semestre}</td>
            <td>${curso.numeroEstudiantesAdmitidos}</td>
        </tr>
    </c:forEach>
</table>

<hr/>

<!-- Formulario para asignar cursos a estudiantes -->
<h2>Assign Courses to Students</h2>
<!-- Formulario para ingresar IDs de Estudiante y Curso -->
    <form action="./EstucurServlet" method="POST">
    <table>
        <tr>
            <td>ID del Estudiante:</td>
            <td><input type="text" name="studentId" required></td>
        </tr>
        <tr>
            <td>ID del Curso:</td>
            <td><input type="text" name="cursoId" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Assign Courses" />
            </td>
        </tr>
    </table>
</form>

    <!-- Tabla para mostrar las asignaciones realizadas -->
    <h2>Asignaciones Realizadas</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID del Estudiante</th>
                <th>ID del Curso</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allAssignments}" var="assignment">
                <tr>
                    <td>${assignment.estudianteCursoPK.estudianteId}</td>
                    <td>${assignment.estudianteCursoPK.cursoId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
