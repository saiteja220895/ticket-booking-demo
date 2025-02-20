package com.ticket.booking.Ticket.Booking.Entity;

import lombok.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, String> stationTimes;
    private List<String> stations;

    public String getTrainInfo(){
        return  String.format("Train ID: %s Train No: %s", trainId, trainNo);
    }
}
