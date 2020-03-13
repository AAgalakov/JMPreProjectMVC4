package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repositorys.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImplEntityMa implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
//    @SuppressWarnings("unchecked")
    public List<User> allUser() {
//        String query = "from User order by id";
//        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getOne(id);
//        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {//todo все ключевые слова выделять с больших букв
        String query = "update users set name = ?, password = ?, role = ?, age = ? where id = ?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, user.getName());
        nativeQuery.setParameter(2, user.getPassword());
        nativeQuery.setParameter(3, user.getRole());
        nativeQuery.setParameter(4, user.getAge());
        nativeQuery.setParameter(5, user.getId());
        nativeQuery.executeUpdate();
    }

    @Override
    public void addUser(User user) {
        String qlString = "insert into users (name,password,role, age) values (?,?,?,?)";
        Query query = entityManager.createNativeQuery(qlString);
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getPassword());
        query.setParameter(3, user.getRole());
        query.setParameter(4, user.getAge());
        query.executeUpdate();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(getUserById(id));
//        String qlString = "delete from users where id=?";
//        Query query = entityManager.createNativeQuery(qlString);
//        query.setParameter(1, id);
//        query.executeUpdate();
    }
}

