package org.participation.repository;

import org.participation.base.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Integer> {

    @Query("SELECT tp FROM TravelPackage tp JOIN tp.destination d " +
            "WHERE (d.location LIKE %:destination% OR d.country LIKE %:destination%) " +
            "AND tp.startDate >= :startDate AND tp.endDate <= :endDate " +
            "AND tp.price <= :budget " +
            "ORDER BY tp.price ASC")
    List<TravelPackage> searchPackages(@Param("destination") String destination,
                                       @Param("startDate") LocalDate startDate,
                                       @Param("endDate") LocalDate endDate,
                                       @Param("budget") BigDecimal budget);
}
