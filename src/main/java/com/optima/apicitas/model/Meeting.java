package com.optima.apicitas.model;

import com.optima.apicitas.dto.DataMeetingRegister;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String consultation;
    private String project;
    private LocalDateTime creationDate;

    // al ser asignada
    private LocalDateTime assignmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @Enumerated(EnumType.STRING)
    private MeetingStatus state;

    // al ser cerrado
    private LocalDateTime closingDate;

    public Meeting() {
    }

    public Meeting(Long id, String consultation, String project, LocalDateTime creationDate, LocalDateTime assignmentDate, MeetingStatus state, Agent agent, LocalDateTime closingDate) {
        this.id = id;
        this.consultation = consultation;
        this.project = project;
        this.creationDate = creationDate;
        this.assignmentDate = assignmentDate;
        this.state = state;
        this.agent = agent;
        this.closingDate = closingDate;
    }

    public Meeting(DataMeetingRegister data) {
        LocalDateTime now = LocalDateTime.now();
        this.consultation = data.consultation();
        this.project = data.project();
        this.creationDate = now;
        this.state = MeetingStatus.NEW;
    }

    public void setAgentN(Agent agent) {
        this.agent = agent;
    }

    public void setAssignmentDateN(LocalDateTime assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public void setStateN(MeetingStatus state) {
        this.state = state;
    }

    public void setClosingDateN(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public Long getId() {
        return id;
    }

    public String getConsultation() {
        return consultation;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getAssignmentDate() {
        return assignmentDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public MeetingStatus getState() {
        return state;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }
}
