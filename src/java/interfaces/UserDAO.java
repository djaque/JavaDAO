/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.UserDTO;
import java.util.List;

/**
 *
 * @author dany
 */
public interface UserDAO {
    
    public int create(UserDTO u);
    public int update(UserDTO u);
    public int delete(UserDTO u);
    public UserDTO get(int id);
    public List<UserDTO> getAll();
    public UserDTO findByEmail(String email);
    public UserDTO findByName (String name);
}
