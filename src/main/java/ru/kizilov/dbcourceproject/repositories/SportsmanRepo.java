package ru.kizilov.dbcourceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import ru.kizilov.dbcourceproject.models.Sportsman;

import java.util.List;

public interface SportsmanRepo extends JpaRepository<Sportsman, Long> {
    Sportsman findByAlias(String alias);

    List<Sportsman> findByGrowthAfter(int growth);
    List<Sportsman> findByWeightAfter(int weight);
}
