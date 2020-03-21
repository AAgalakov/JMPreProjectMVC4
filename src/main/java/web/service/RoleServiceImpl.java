package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> allRoles() {
        return roleDao.allRole();
    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public void deleteRole(Long id) {

    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }
}
