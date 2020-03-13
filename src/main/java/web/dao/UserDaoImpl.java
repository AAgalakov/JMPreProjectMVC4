package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
import java.util.Optional;

//@Repository
//@Transactional
public class UserDaoImpl implements UserDao {

    // todo сделать через entity manager done

    private SessionFactory sessionFactory;

    //todo прочитать
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUser() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Optional<User> optionalUser = Optional.ofNullable(session.load(User.class, id));
        optionalUser.ifPresent(session::delete);
    }

    @Override
    public User getUserById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
