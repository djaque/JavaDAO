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
public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();
    
    
    //Constants for DB access
    public static final int MYSQL = 1;
    public static final int POSTGRESQL = 2;

    

    public static DAOFactory getDAOFactory(int qFactory) {
        switch (qFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            //case POSTGRESQL:
            //    return new PostgresqlDAOFactory();
            default:
                return null;
        }
    }

}
