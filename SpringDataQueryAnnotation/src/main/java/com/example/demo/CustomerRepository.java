package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT e FROM Customer e ORDER BY e.name DESC")
    List<Customer> findAllOrderByNameDesc();
    @Query(value = "SELECT e.* FROM customer e ORDER BY e.name DESC", nativeQuery = true)
    List<Customer> findAllOrderByNameDescNative();
    @Query("SELECT e FROM Customer e WHERE e.name = ?1")
    List<Customer> findByName(String name);
    @Query("SELECT e FROM Customer e WHERE e.name = :name AND e.address = :address")
    List<Customer> findByNameAndAddress(@Param("name") String name, @Param("address") String address);
    @Query("SELECT e FROM Customer e WHERE e.name like ?1")
    List<Customer> findByNameLike(String name);

    //my custom delete
    @Transactional
    @Modifying
    @Query(value = "DELETE from Customer c")
    void myDelete();
}
