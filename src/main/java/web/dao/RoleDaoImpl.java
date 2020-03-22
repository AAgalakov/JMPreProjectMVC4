package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> allRole() {
        String query = "FROM Role ORDER BY id";
        TypedQuery<Role> typedQuery = entityManager.createQuery(query, Role.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(getRoleById(id));
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @Transactional
    public Role getRoleByName(String role) {
        return entityManager.createQuery("SELECT t FROM Role t WHERE t.nameRole =:role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }
}
