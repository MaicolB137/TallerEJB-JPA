/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;


import co.edu.unipiloto.arquitectura.student.entity.Cursos;
import co.edu.unipiloto.arquitectura.student.entity.Student;
import co.edu.unipiloto.arquitectura.student.session.CursosFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {
    @EJB
    private CursosFacadeLocal cursoFacade;

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
        
        String codigoCurso = request.getParameter("codigoCurso");

        String nombreCurso = request.getParameter("nombreCurso");
        String numeroCreditosStr = request.getParameter("numeroCreditos");
        Integer numeroCreditos = null;
        if (numeroCreditosStr != null && !numeroCreditosStr.trim().isEmpty()) {
            try {
                numeroCreditos = Integer.parseInt(numeroCreditosStr);
            } catch (NumberFormatException e) {
               
            }
        }

        String semestreStr = request.getParameter("semestre");
        Integer semestre = null;
        if (semestreStr != null && !semestreStr.trim().isEmpty()) {
            try {
                semestre = Integer.parseInt(semestreStr);
            } catch (NumberFormatException e) {
                
            }
        }
        String numeroEstudiantesAdmitidosStr = request.getParameter("numeroEstudiantesAdmitidos");
        Integer numeroEstudiantesAdmitidos = null;
        if (numeroEstudiantesAdmitidosStr != null && !numeroEstudiantesAdmitidosStr.trim().isEmpty()) {
            try {
                numeroEstudiantesAdmitidos = Integer.parseInt(numeroEstudiantesAdmitidosStr);
            } catch (NumberFormatException e) {
                
            }
        }

        Cursos curso = new Cursos(codigoCurso, nombreCurso, numeroCreditos, semestre, numeroEstudiantesAdmitidos);

        if ("Add".equalsIgnoreCase(action)) {
            cursoFacade.create(curso);
        } else if ("Edit".equalsIgnoreCase(action)) {
            cursoFacade.edit(curso);
        } else if ("Delete".equalsIgnoreCase(action)) {
            cursoFacade.remove(curso);
        } else if ("Search".equalsIgnoreCase(action)) {
            curso = cursoFacade.find(codigoCurso);
            List<Cursos> cursor = new ArrayList<>();
            if (curso != null) {
                cursor.add(curso);
            }
            request.setAttribute("curso", curso);
            request.setAttribute("allCursos", cursor);
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            return;
        }
        List<Cursos> cursor = cursoFacade.findAll();
        request.setAttribute("curso", curso);
        request.setAttribute("allCursos", cursor);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);

//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CursoServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CursoServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
