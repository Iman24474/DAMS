package com.cs5800.dams.service;

import com.cs5800.dams.entity.Donation;
import com.cs5800.dams.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    public void save(Donation donation)
    {
        donationRepository.save(donation);
    }

    public List<Donation> getAllDonations()
    {
        return donationRepository.findAll();
    }

    public void deleteById(int id)
    {
        donationRepository.deleteById(id);
    }
}
