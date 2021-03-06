/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitternt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import twitternt.dao.UsuarioFacade;
import twitternt.entity.Usuario;

/**
 *
 * @author Trigi
 */
@WebServlet(name = "ServletMenu", urlPatterns = {"/ServletMenu"})
public class MenuServlet extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

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
               
        String botonPulsado = request.getParameter("boton");
        
        if (botonPulsado.equals("Inicio")){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/IndexServlet");
                rd.forward(request, response);
        } else if (botonPulsado.equals("Amigos")){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AmigosServlet");
                rd.forward(request, response);
        } else if (botonPulsado.equals("Perfil")){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/PerfilServlet");
                rd.forward(request, response);
        } else if (botonPulsado.equals("Solicitudes")){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/SolicitudesServlet");
                rd.forward(request, response);
        } else if (botonPulsado.equals("Grupos")){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GruposServlet");
                rd.forward(request, response);
        } else if (botonPulsado.equals("Logout")){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CerrarSesionServlet");
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
