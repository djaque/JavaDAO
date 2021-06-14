/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UserDTO;
import db.MysqlConnection;
import interfaces.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dany
 */
public class MySQLUserDAO implements UserDAO {

    final String SELECTALL = "SELECT * FROM usuarios";
    final String SELECTBYID = "SELECT * FROM usuarios WHERE id = ?";
    final String SELECTBYEMAIL = "SELECT * FROM usuarios WHERE email = ?";
    final String SELECTBYNAME = "SELECT * FROM usuarios WHERE name = ?";

    final String CREATE = "INSERT INTO usuarios (nombre, email, password) VALUES (?,?,?)";
    final String UPDATE = "UPDATE usuarios SET nombre = ?, email = ?, password = ? WHERE id = ?";
    final String DELETE = "DELETE FROM usuarios WHERE id = ?";

    @Override
    public int create(UserDTO u) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.CREATE);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            rs = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return rs;
    }

    @Override
    public int update(UserDTO u) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.UPDATE);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getId());
            rs = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return rs;
    }

    @Override
    public int delete(UserDTO u) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.DELETE);
            ps.setInt(1, u.getId());
            rs = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return rs;
    }

    @Override
    public UserDTO get(int id) {
        UserDTO u = null;

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTBYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }

        return u;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> lu = new ArrayList<>();
        Connection conn = null;
        Statement ps = null;
        try {
            conn = MysqlConnection.open();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.SELECTALL);
            while (rs.next()) {
                UserDTO u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                lu.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return lu;
    }

    @Override
    public UserDTO findByEmail(String email) {
        UserDTO u = null;

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTBYEMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }

        return u;
    }

    @Override
    public UserDTO findByName(String name) {
        UserDTO u = null;

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.SELECTBYNAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return u;
    }

}
