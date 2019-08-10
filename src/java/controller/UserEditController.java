/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UserDTO;
import interfaces.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

/**
 *
 * @author dany
 */
public class UserEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            int parsedInt = Integer.parseInt(id);
            UserService userService = new UserService();
            UserDTO userDTO = userService.get(parsedInt);
            if (null != userDTO) {
                request.setAttribute("user", userDTO);
            }
        }
        request.getRequestDispatcher("user_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        if (id != null && action != null) {

            int parsedInt = Integer.parseInt(id);
            UserService userService = new UserService();
            UserDTO userDTO = userService.get(parsedInt);

            if (action.equals("edit")) {

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String passwd = request.getParameter("password");

                if (null != name && null != email && null != passwd) {

                    userDTO.setName(name);
                    userDTO.setEmail(email);
                    userDTO.setPassword(passwd);

                    if (userService.update(userDTO) == 1) {
                        request.setAttribute("status", "Usuario actualizado");
                    } else {
                        request.setAttribute("status", "No se pudo actualizar");
                    }
                    request.setAttribute("user", userDTO);
                }
            } else {
                if (action.equals("delete")) {
                    if (userService.delete(userDTO) == 1) {
                        request.setAttribute("status", "Usuario eliminado");
                    } else {
                        request.setAttribute("status", "No se pudo eliminar");
                    }
                }
            }
        }
        request.getRequestDispatcher("user_edit.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Edita/Elimina un usuario";
    }

}
