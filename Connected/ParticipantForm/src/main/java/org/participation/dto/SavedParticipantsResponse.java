package org.participation.dto;

import lombok.Data;
import org.participation.base.Participant;

import java.util.List;

@Data
public class SavedParticipantsResponse {
    private String message;
    private List<Participant> participants;

    public SavedParticipantsResponse(String message, List<Participant> participants) {
        this.message = message;
        this.participants = participants;
    }
}