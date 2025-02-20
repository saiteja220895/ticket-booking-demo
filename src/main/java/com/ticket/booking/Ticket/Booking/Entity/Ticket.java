package com.ticket.booking.Ticket.Booking.Entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

    public String getTicketInfo(){
        return  String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketId, userId, source, destination);
    }

}
