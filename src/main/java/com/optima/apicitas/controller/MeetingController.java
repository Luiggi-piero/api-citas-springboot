package com.optima.apicitas.controller;

import com.optima.apicitas.dto.DataMeetingRegister;
import com.optima.apicitas.model.Meeting;
import com.optima.apicitas.model.MeetingStatus;
import com.optima.apicitas.service.IMeetingService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private IMeetingService service;

    @PostMapping
    @Transactional
    public ResponseEntity createMeeting(@RequestBody @Valid DataMeetingRegister data){
        service.createMeeting(new Meeting(data));
        return ResponseEntity.ok("Cita creada con éxito");
    }

    @PutMapping("/assign/{idAgent}/{idMeeting}")
    @Transactional
    public ResponseEntity assignMeeting(@PathVariable Long idAgent, @PathVariable Long idMeeting){
        service.assignMeeting(idAgent, idMeeting);
        return ResponseEntity.ok("Cita asignada con éxito");
    }

    @GetMapping("/agent/{idAgent}")
    public ResponseEntity<List<Meeting>> getMeetingsByAgent(@PathVariable Long idAgent){
        return ResponseEntity.ok(service.getMeetingsByAgent(idAgent));
    }

    @PutMapping("/complete/{idMeeting}")
    @Transactional
    public ResponseEntity completeMeeting(@PathVariable Long idMeeting){
        service.completeMeeting(idMeeting);
        return ResponseEntity.ok("Cita completada");
    }

    @GetMapping("/complete/{idMeeting}")
    public ResponseEntity<Meeting> getMeetingCompleteById(@PathVariable Long idMeeting){
        return ResponseEntity.ok(service.getMeetingByIdAndStatus(idMeeting, MeetingStatus.COMPLETE));
    }
}
