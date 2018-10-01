package ru.kizilov.dbcourceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kizilov.dbcourceproject.models.Fight;

import java.util.List;

public interface FightRepo extends JpaRepository<Fight, Long> {

}
