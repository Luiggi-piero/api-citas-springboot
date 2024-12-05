package com.optima.apicitas.service;

import com.optima.apicitas.model.Meeting;
import com.optima.apicitas.model.MeetingStatus;

import java.util.List;

public interface IMeetingService {
    void createMeeting(Meeting meeting);

    void assignMeeting(Long idAgent, Long idMeeting);

    List<Meeting> getMeetingsByAgent(Long idAgent);

    void completeMeeting(Long idMeeting);

    Meeting getMeetingByIdAndStatus(Long idMeeting, MeetingStatus status);
}
