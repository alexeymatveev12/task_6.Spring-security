package task5.spring.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task5.spring.dao.RoleDao;
import task5.spring.model.Role;
import task5.spring.model.User;
import task5.spring.dao.UserDao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
        //("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

 //   @Autowired
    private RoleDao roleDao;

//    @Autowired
//    @Bean
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao /* , BCryptPasswordEncoder bCryptPasswordEncoder*/) {
        this.userDao = userDao;
        this.roleDao = roleDao;
      //  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //   @Autowired
 //   public UserServiceImpl(UserDao userDao) {
 //       this.userDao = userDao;
 //   }

 //   @Autowired
 //   public UserServiceImpl(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }






    @Deprecated
    //setter - deprecated
    //  @Autowired
    //  public void setUserDao(UserDao userDao) {
    //       this.userDao = userDao;
    //   }


    //1-й получить список всех пользователей
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.userDao.getAllUsersDao();
    }



    //2-й получить пользователя по ID
    @Override
    @Transactional
    public User getUserById(long id) /*throws SQLException*/ {
        return userDao.getUserById(id);
    }

    //3-й проверить есть ли зарегистрированный пользователь с искомым именем
    @Override
    @Transactional
    public boolean checkUserByName(String name) throws SQLException {
        return false;
    }

    //4-й проверить есть ли зарегистрированный пользователь с искомым логином
    @Override
    @Transactional
    public boolean checkUserByLogin(String login) throws SQLException {
        return false;
    }

    //5-й создать и добавить в базу нового пользователя
    @Override
    @Transactional
    public void addUser(User user) {
        System.out.println("userservise - add user");
        userDao.addUser(user);
    }

    //6-й обновить и записать в базу новые данные пользователя
    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    //7-й удалить пользователя через ID
    @Override
    @Transactional
    public void deleteUserById(long id) /*throws SQLException*/ {
        userDao.deleteUserByIdDao(id);

    }

    //8-й проверить есть ли зарегистрированный пользователь
    // с искомым login и password
    @Override
    @Transactional
    public User isExist(String login, String password) {
        return null;
    }


    @Override
    public void save(User user) {
      //  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      //  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }



}