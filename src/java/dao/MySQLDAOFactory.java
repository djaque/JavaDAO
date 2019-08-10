/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.UserDAO;

/**
 *
 * @author dany
 */
public class MySQLDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }
    
}
