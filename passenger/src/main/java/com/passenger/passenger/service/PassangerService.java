package com.passenger.passenger.service;

import com.passenger.passenger.DTO.PassangerDTO;
import com.passenger.passenger.model.Passanger;
import com.passenger.passenger.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PassangerService {

    private PassengerRepository passangerRepository;

    @Autowired
    public PassangerService(PassengerRepository passangerRepository) {
        this.passangerRepository = passangerRepository;
    }

    public List<Passanger> getAllPassangers() {
        List<Passanger> passangers;
        try {
            passangers =  passangerRepository.findAll();
        } catch (Exception e){
            throw new EntityNotFoundException("Passengers not found");
        }
        return passangers;
    }

    public Passanger getPassangerById(long id) {
        Passanger passanger =  passangerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        return passanger;
    }

    public List<Passanger> getPassangerByName(String name) {
        List<Passanger> passangers =  passangerRepository.findByFirstName(name);
        return passangers;
    }

    public Passanger createPassanger(PassangerDTO passangerDTO) {
        Passanger passanger = new Passanger();
        passanger.setFirstName(passangerDTO.getFirstName());
        passanger.setLastName(passangerDTO.getLastName());
        passanger.setEmail(passangerDTO.getEmail());
        return passangerRepository.save(passanger);
    }

    public Passanger updatePassanger(long id, PassangerDTO passangerDTO) {
        Passanger passanger = passangerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Passenger not found"));

        if(passangerDTO.getFirstName() != null) passanger.setFirstName(passangerDTO.getFirstName());
        if(passangerDTO.getLastName() != null) passanger.setLastName(passangerDTO.getLastName());
        if(passangerDTO.getEmail() != null) passanger.setEmail(passangerDTO.getEmail());

        return passangerRepository.save(passanger);
    }

    public void deletePassanger(long id) {
        passangerRepository.deleteById(id);
    }

    public void deleteAllPassangers() {
        passangerRepository.deleteAll();
    }

}
