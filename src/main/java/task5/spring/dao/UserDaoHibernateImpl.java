package task5.spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task5.spring.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Deprecated
    //setter - deprecated
//    @Autowired
//        public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    //1-й получить список всех пользователей
    @Override
    public List<User> getAllUsersDao() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<User> allUsers = session.createQuery("FROM User").list();
//        transaction.commit();
//        session.close();
//        return allUsers;

 //       System.out.println("open the session");
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User").list();
 //       System.out.println("return the list of users");
        return allUsers;

    }



    //2-й получить пользователя по ID
    @Override
    public User getUserById(long id) /*throws SQLException*/ {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("from User where id = :userId");
//        List<User> userList = query.setParameter("userId", id).list();
//        User user = userList.get(0);
//
//        transaction.commit();
//        session.close();
//        return user;
        //      Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.getCurrentSession();
        return (User) session.load(User.class, id);
    }

    //3-й проверить есть ли зарегистрированный пользователь с искомым именем
    @Override
    public boolean checkUserByName(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where name = :userName");
        List<User> userList = query.setParameter("userName", name).list();

        transaction.commit();
        session.close();
        if (userList.size() > 0) {
            return false;
        } else return true;
    }

    //4-й проверить есть ли зарегистрированный пользователь с искомым логином
    @Override
    public boolean checkUserByLogin(String login) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where login = :userLogin");
        List<User> userList = query.setParameter("userLogin", login).list();
        transaction.commit();
        session.close();
        if (userList.size() > 0) {
            return false;
        } else return true;
    }

    //5-й создать и добавить в базу нового пользователя
    @Override
    public void addUser(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(user);
//        transaction.commit();
//        session.close();
        System.out.println("Добавляю юзера в Базу");
        Session session = sessionFactory.getCurrentSession();
      //  session.save(user);

        session.persist(user);

    }

    //6-й обновить и записать в базу новые данные пользователя
    // @Override
    public void updateUser(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(user);
//        transaction.commit();
//        session.close();

        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }


    public void updateUser2(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("UPDATE User SET name=:name, login=:login, password=:password, role=:role WHERE id=:id")
                .setParameter("name", user.getName())
                .setParameter("login", user.getLogin())
                .setParameter("password", user.getPassword())
                .setParameter("role", user.getRole())
                .setParameter("id", user.getId())
                .executeUpdate();

        transaction.commit();
    }

    //7-й удалить пользователя через ID
    @Override
    public void deleteUserByIdDao(long id) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("DELETE FROM User WHERE id = :userId");
//        query.setParameter("userId", id);
//        query.executeUpdate();
//        transaction.commit();
//        session.close();


        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);

        session.delete(user);

    }


    //8-й проверить есть ли зарегистрированный пользователь
    // с искомым login и password
    @Override
    public User isExist(String login, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where login = :userLogin");
        List<User> userList = query.setParameter("userLogin", login).list();

        User userExist = null;
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                userExist = user;
            }
        }
        transaction.commit();
        session.close();
        return userExist;
    }

    //9-й проверка по логину  - Секьюрити
    @Override
    public User findUserByLogin(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        return (User) session.load(User.class, login);
    }

    //10-й сохранение?????  - Секьюрити
    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }



}