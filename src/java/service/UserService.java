/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.UserDTO;
import dao.DAOFactory;
import interfaces.UserDAO;
import java.util.List;

/**
 *
 * @author dany
 */
public class UserService  {
    // Select mysql to work
    DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    
    // Implements methods using selected DB
    UserDAO userDAO = factory.getUserDAO();
    
    public int create(UserDTO u){
        return userDAO.create(u);
    }
    public int update(UserDTO u){
        return userDAO.update(u);
    }
    public int delete(UserDTO u){
        return userDAO.delete(u);
    }
    public UserDTO get(int id){
        return userDAO.get(id);
    }
    public List<UserDTO> getAll(){
        return userDAO.getAll();
    }
    public UserDTO findByEmail(String email){
        return userDAO.findByEmail(email);
    }
    public UserDTO findByName (String name){
        return userDAO.findByName(name);
    }
}
