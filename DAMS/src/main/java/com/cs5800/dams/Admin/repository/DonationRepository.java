package com.cs5800.dams.Admin.repository;

import com.cs5800.dams.Admin.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

}
