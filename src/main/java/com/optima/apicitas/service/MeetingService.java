package com.optima.apicitas.service;

import com.optima.apicitas.model.Agent;
import com.optima.apicitas.model.Meeting;
import com.optima.apicitas.model.MeetingStatus;
import com.optima.apicitas.respository.IAgentRepository;
import com.optima.apicitas.respository.IMeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingService implements IMeetingService {

    @Autowired
    private IMeetingRepository meetingRepository;

    @Autowired
    private IAgentRepository agentRepository;

    @Override
    public void createMeeting(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    @Override
    public void assignMeeting(Long idAgent, Long idMeeting) {
        Meeting meeting = meetingRepository.findById(idMeeting).orElse(null);
        if(meeting == null){
            System.out.println("Reunión no encontrada");
            return;
        }

        //System.out.println("meeting " + meeting);
        Agent agent = agentRepository.findById(idAgent).orElse(null);
        if(agent == null){
            System.out.println("Agente no encontrado");
            return;
        }

        meeting.setAgentN(agent);
        meeting.setAssignmentDateN(LocalDateTime.now());
        meeting.setStateN(MeetingStatus.PENDING);
        meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> getMeetingsByAgent(Long idAgent) {
        List<Meeting> meetings = meetingRepository.findByAgentIdAndState(idAgent, MeetingStatus.PENDING);
        return meetings;
    }

    @Override
    public void completeMeeting(Long idMeeting) {
        Meeting meeting = meetingRepository.findById(idMeeting).orElse(null);
        if(meeting == null){
            System.out.println("Cita no encontrada");
            return;
        }

        meeting.setStateN(MeetingStatus.COMPLETE);
        meeting.setClosingDateN(LocalDateTime.now());
        meetingRepository.save(meeting);
    }

    @Override
    public Meeting getMeetingByIdAndStatus(Long idMeeting, MeetingStatus status) {
        return meetingRepository.findByIdAndState(idMeeting, status);
    }
}
