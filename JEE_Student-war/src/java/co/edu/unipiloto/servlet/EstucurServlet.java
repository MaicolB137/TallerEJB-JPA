/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.student.entity.Cursos;
import co.edu.unipiloto.arquitectura.student.entity.EstudianteCurso;
import co.edu.unipiloto.arquitectura.student.entity.EstudianteCursoPK;
import co.edu.unipiloto.arquitectura.student.entity.Student;
import co.edu.unipiloto.arquitectura.student.session.CursosFacadeLocal;
import co.edu.unipiloto.arquitectura.student.session.EstudianteCursoFacadeLocal;
import co.edu.unipiloto.arquitectura.student.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
@WebServlet(name = "EstucurServlet", urlPatterns = {"/EstucurServlet"})
public class EstucurServlet extends HttpServlet {

    @EJB
    private EstudianteCursoFacadeLocal studentCurFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        System.out.println("Action received: " + action);

        if ("Assign Courses".equalsIgnoreCase(action)) {
            String studentIdst = request.getParameter("studentId");
            String cursoId = request.getParameter("cursoId");
            Integer studentId = null;

            System.out.println("Student ID: " + studentIdst);
            System.out.println("Course ID: " + cursoId);

            if (studentIdst != null && !studentIdst.trim().isEmpty()) {
                try {
                    studentId = Integer.parseInt(studentIdst);
                } catch (NumberFormatException e) {
                    System.err.println("NumberFormatException: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            if (studentId != null && cursoId != null && !cursoId.trim().isEmpty()) {
                try {
                    EstudianteCursoPK estudianteCursoPK = new EstudianteCursoPK(studentId, cursoId);
                    EstudianteCurso estudianteCurso = new EstudianteCurso(estudianteCursoPK);
                    studentCurFacade.create(estudianteCurso);
                    System.out.println("Successfully created EstudianteCurso.");
                } catch (Exception e) {
                    System.err.println("Exception: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.err.println("Invalid studentId or cursoId");
            }
        }

        List<EstudianteCurso> allAssignments = studentCurFacade.findAll();
        System.out.println("Assignments retrieved: " + allAssignments);

        request.setAttribute("allAssignments", allAssignments);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
//       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
