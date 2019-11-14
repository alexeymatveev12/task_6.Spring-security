package task5.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task5.spring.dao.UserDao;
import task5.spring.model.Role;
import task5.spring.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService} interface.

 */

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    // @Autowired
    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
//создаю новый сет разрешений
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//в цикле дабавлюя в разрешения пользователя все роли, которые храняться в БД
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        //юзер: имя, пароль, РАЗРЕШЕНИЯ (из ролей)
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}