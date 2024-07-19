package com.rickycodesux.planner.participant;

import com.rickycodesux.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// classe generica que reune todos os servicos de participante
@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip){

        List<Participant> participants =  participantsToInvite
                .stream().map(email -> new Participant(email, trip)).toList();

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());

    }

    // metodo para disparar o email de confirmacao
    public void triggerConfirmationEmailToParticipants(UUID tripId) {};


}