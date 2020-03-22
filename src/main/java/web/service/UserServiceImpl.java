package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dto.UserDto;
import web.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    private UserDao userDao;

    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
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
    public User getUserByName(String name) throws UsernameNotFoundException {
        return userDao.getUserByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return getUserByName(s);
    }

    private void setRoles(User user, UserDto userDto) {
        user.setRoles(Arrays.stream(userDto.getRoles())
                .map(role -> roleService.getRoleByName(role))
                .collect(Collectors.toSet()));
    }

    private boolean isNameUnique(UserDto userDto) {
        return !userDao.getUserByName(userDto.getName()).isPresent();
    }

    private User fromForm(UserDto userDto) {
        User user = new User(userDto);
        setRoles(user, userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }
}
