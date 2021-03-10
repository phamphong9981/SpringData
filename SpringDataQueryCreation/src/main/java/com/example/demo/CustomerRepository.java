package com.example.demo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByOrderByNameDesc();

    List<Customer> findByName(String name);

    List<Customer> findByNameAndAddress(String name, String address);

    List<Customer> findByNameLike(String name);

    List<Customer> findByIdIn(List<Integer> ids);

    List<Customer> findByIdLessThan(int index);
}
