package com.rickycodesux.planner.participant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// classe generica que reune todos os servicos de participante
@Service
public class ParticipantService {

    public void registerParticipantsToEvent(
            List<String> participantsToInvite,
            UUID id
    ) {

    }

    // metodo para disparar o email de confirmacao
    public void triggerConfirmationEmailToParticipants(UUID tripId) {};


}