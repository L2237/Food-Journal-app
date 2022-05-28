package com.springboot.app.repositories;


import com.springboot.app.entities.Serving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServingRepository extends JpaRepository<Serving, Integer> {

}
