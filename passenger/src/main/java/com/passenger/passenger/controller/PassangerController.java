package com.passenger.passenger.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.passenger.passenger.DTO.PassangerDTO;
import com.passenger.passenger.model.Passanger;
import com.passenger.passenger.repository.PassengerRepository;
import com.passenger.passenger.service.PassangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/passangers")
public class PassangerController {


    private PassengerRepository passangerRepository;
    private PassangerService passangerService;

    @Autowired
    public PassangerController(PassengerRepository passangerRepository, PassangerService passangerService){
        this.passangerRepository = passangerRepository;
        this.passangerService = passangerService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPassangers() {
        try {
            List<Passanger> passangers = passangerService.getAllPassangers();
            if (passangers.isEmpty()) {
                return new ResponseEntity<>("No passangers found.",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(passangers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<?> getPassangerByName(@RequestParam String name) {
        try {

            List<Passanger> passangers =  passangerService.getPassangerByName(name);

            if (passangers.isEmpty()) {
                return new ResponseEntity<>("None passanger found.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(passangers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Passanger> getPassangerById(@RequestParam("id") long id) {
        try {
            Passanger passanger = passangerService.getPassangerById(id);
            return new ResponseEntity<>(passanger, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Passanger> createPassanger(@RequestBody PassangerDTO passangerDTO) {
        try {
            Passanger passanger = passangerService.createPassanger(passangerDTO);
            return new ResponseEntity<>(passanger, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePassanger(@PathVariable("id") long id, @RequestBody PassangerDTO passangerDTO) {
        try {
            Passanger passanger = passangerService.updatePassanger(id,passangerDTO);
            return new ResponseEntity<>(passanger, HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePassanger(@PathVariable("id") long id) {
        try {
            passangerService.deletePassanger(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllPassangers() {
        try {
            passangerService.deleteAllPassangers();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}