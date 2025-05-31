package com.system.railway.repository;

import com.system.railway.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByTrainNumber(String trainNumber);
    List<Train> findByDestination(String destination);
    List<Train> findByDestinationContainingIgnoreCase(String destination);

}
