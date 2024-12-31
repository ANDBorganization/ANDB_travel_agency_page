package org.participation.controller;

import org.participation.dto.ParticipantDTO;
import org.participation.base.Participant;
import org.participation.repository.ParticipantRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping
    public ResponseEntity<?> validateParticipants(
            @RequestBody @Valid List<ParticipantDTO> participants,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.add(error.getField() + ": " + error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }

        List<Participant> entities = participants.stream().map(dto -> {
            Participant participant = new Participant();
            participant.setName(dto.getName());
            participant.setSurname(dto.getSurname());
            participant.setDateOfBirth(dto.getDateOfBirth());
            participant.setAddress(dto.getAddress());
            participant.setEmail(dto.getEmail());
            participant.setPhone(dto.getPhone());
            return participant;
        }).toList();

        participantRepository.saveAll(entities);

        return ResponseEntity.status(HttpStatus.CREATED).body("Participants saved successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants() {
        return ResponseEntity.ok(participantRepository.findAll());
    }
}
