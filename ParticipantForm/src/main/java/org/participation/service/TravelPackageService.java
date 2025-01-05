package org.participation.service;

import org.participation.base.TravelPackage;
import org.participation.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    public List<TravelPackage> searchTravelPackages(String destination, LocalDate startDate, LocalDate endDate, BigDecimal budget) {
        return travelPackageRepository.searchPackages(destination, startDate, endDate, budget);
    }
}
