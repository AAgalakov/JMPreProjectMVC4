package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.controllers.UserController;
import web.dao.UserDao;
import web.dto.UserDto;
import web.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserController.class.getName());

    private UserDao userDao;

    private RoleService roleService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUser();
    }

    @Override
    public boolean addUser(UserDto userDto) {
        if (!isNameUnique(userDto)) {
            return false;
        }
        User user = fromForm(userDto);
        userDao.addUser(user);
        return true;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        log.info(userDto.toString());
        if (getUserById(userDto.getId()).getName().equals(userDto.getName()) || isNameUnique(userDto)) {
            User user = fromForm(userDto);
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return Optional.of(userDao.getUserByName(s)).orElseThrow(IllegalAccessError::new);
    }

    private void setRoles(User user, UserDto userDto) {
        user.setRoles(Arrays.stream(userDto.getRoles())// "user" , "admin"
                .map(role -> roleService.getRoleByName(role)) // Role "user"; Role "admin"
                .collect(Collectors.toSet()));
    }

    private boolean isNameUnique(UserDto userDto) {
        return userDao.getUserByName(userDto.getName()) == null;
    }

    private User fromForm(UserDto userDto){
        User user = new User(userDto);
        setRoles(user, userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }
}
