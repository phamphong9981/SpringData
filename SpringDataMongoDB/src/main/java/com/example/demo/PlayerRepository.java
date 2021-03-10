package com.example.demo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerRepository extends MongoRepository<Player, String>{

    @Query("{ 'name': ?0}")
    List<Player> findByName(String name);

    List<Player> findByNameLike(String name);
}
