package ma.emsi.jpaemsi.Service;

import ma.emsi.jpaemsi.entities.User;
import ma.emsi.jpaemsi.entities.Role;

public interface UserService  {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleBuRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate(String userName,String password);

}
