package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> allRole();

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    Role getRoleById(Long id);

    Role getRoleByName(String role);

}
