package com.optima.apicitas.respository;

import com.optima.apicitas.model.Meeting;
import com.optima.apicitas.model.MeetingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByAgentIdAndState(Long agentId, MeetingStatus state);

    Meeting findByIdAndState(Long idMeeting, MeetingStatus status);
}
