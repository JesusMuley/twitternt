/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitternt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import twitternt.dao.PostFacade;
import twitternt.dao.UsuarioFacade;
import twitternt.entity.Post;
import twitternt.entity.Usuario;

 
/**
 *
 * @author adry1
 */
@WebServlet(name = "GrupoPostServlet", urlPatterns = {"/GrupoPostServlet"})
public class GrupoPostServlet extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private PostFacade postFacade;
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
        try {
                    HttpSession session = request.getSession(true);  
                    String texto = (String) request.getParameter("texto");
                    Integer vi = Integer.parseInt(request.getParameter("visibilidad"));
                    Usuario u = usuarioFacade.findById((Integer) session.getAttribute("usuario"));
                    Post p = new Post();
                    p.setFechaPublicacion(new Date());
                    p.setTexto(texto);
                    p.setVisibilidad(vi);
                    p.setUsuario(u);
                    postFacade.create(p);
                    u.addPost(p);
                    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GrupoServlet?codigoGrupo="+vi);
                    rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al publicar el post.");
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
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
