package ru.kizilov.dbcourceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kizilov.dbcourceproject.models.Sportsman;

public interface SportsmanRepo extends JpaRepository<Sportsman, Long> {

}
