package ru.kizilov.dbcourceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kizilov.dbcourceproject.models.Role;
import ru.kizilov.dbcourceproject.models.User;
import ru.kizilov.dbcourceproject.repositories.UserRepo;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepo.findByMail(mail);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return user;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByMail(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
