package ru.kizilov.dbcourceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kizilov.dbcourceproject.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByMail(String mail);
}
