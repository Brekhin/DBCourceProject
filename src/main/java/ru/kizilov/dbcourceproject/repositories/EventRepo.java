package ru.kizilov.dbcourceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kizilov.dbcourceproject.models.Event;

public interface EventRepo extends JpaRepository<Event, Long> {
}
