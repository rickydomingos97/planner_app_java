package com.rickycodesux.planner.trip;

import java.util.List;

// como so vou receber dados aqui pode ser somente um "record"
public record TripRequestPayload(
        String destination,
        String starts_at,
        String ends_at,
        List<String> emails_to_invite,
        String owner_name,
        String owner_email
) {
}