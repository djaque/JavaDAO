/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

/**
 *
 * @author dany
 */
public class UserController extends HttpServlet {

    private void populateUsers(HttpServletRequest request, HttpServletResponse response) {
        UserService usersManager = new UserService();
        List<UserDTO> lu = usersManager.getAll();
        request.setAttribute("users", lu);
    }

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
        populateUsers(request, response);
        System.out.println("Procesing Get method");

        request.getRequestDispatcher("users.jsp").forward(request, response);
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
        System.out.println("Procesing Post method");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String passwd = request.getParameter("password");

        if (null != name && null != email && null != passwd) {
            UserDTO u = new UserDTO(name, email, passwd);
            UserService usersManager = new UserService();
            usersManager.create(u);
        } else {
            System.out.println("User cant be created");
        }

        populateUsers(request, response);
        request.getRequestDispatcher("users.jsp").forward(request, response);
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
