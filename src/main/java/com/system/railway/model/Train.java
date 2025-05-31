package com.system.railway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainNumber;
    private String destination;

    private LocalDateTime departureTime;

    // Конструктори
    public Train() {}

    public Train(String trainNumber, String destination, LocalDateTime departureTime) {
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Геттери та сеттери
    public Long getId() { return id; }

    public String getTrainNumber() { return trainNumber; }
    public void setTrainNumber(String trainNumber) { this.trainNumber = trainNumber; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
}
