package com.passenger.passenger.repository;

import com.passenger.passenger.model.Passanger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passanger, Long> {
    // we can use JpaRepository’s methods: save(), findOne(), findById(), findAll(),
    // count(), delete(), deleteById()… without implementing these methods

    // We also define custom finder methods:
    List<Passanger> findByFirstName(String firstName);
    Optional<Passanger> findById(long id);
}
