package com.rickycodesux.planner.trip;

import com.rickycodesux.planner.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    // vamos usar o participante service para registrar os participantes
    // dependencia injetada da classe controller
    @Autowired // injecao de dependencia do Spring
    private ParticipantService participantService;

    @Autowired
    private TripRepository repository;

    // mapeamento do endpoint para a criacao de um novo evento
    // e criar uma classe para receber os dados do request body
    @PostMapping
    public ResponseEntity<TripCreateResponse> createTrip(
            @RequestBody TripRequestPayload payload) {
        // com o payload podemos fazer a criacao de uma nova trip
        Trip newTrip = new Trip(payload);

        // passando a viagem qeu vai ser salva no BD
        this.repository.save(newTrip);

        this.participantService.registerParticipantsToEvent(
                payload.emails_to_invite(),
                newTrip.getId());
        return ResponseEntity.ok(new TripCreateResponse(newTrip.getId()));
    }
}