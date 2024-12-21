package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.entity.CloudVendor;
import com.thinkinnovative.demo_gradle.exception.CloudVendorNotFoundException;
import com.thinkinnovative.demo_gradle.repository.CloudVendorRepository;
import com.thinkinnovative.demo_gradle.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImplementation implements CloudVendorService {
    CloudVendorRepository vendorRepository;
    CloudVendor cloudVendor;
    public CloudVendorServiceImplementation(CloudVendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }


    @Override
    public String createVendor(CloudVendor cloudVendor) {
        vendorRepository.save(cloudVendor);
        return "Vendor created successfully" ;
    }

    @Override
    public String updateVendor(CloudVendor cloudVendor) {
        vendorRepository.save(cloudVendor);
        return "Vendor updated successfully" ;
    }

    @Override
    public String deleteVendor(String vendorId) {
        vendorRepository.deleteById(vendorId);
        return "Success";
    }

    @Override
    public CloudVendor getVendorById(String vendorId) {
        System.out.println("This Is ByID Implementation");
        if (vendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Vendor not found");
            // new word is required to initiate the object we can't use old object as every timee new message wil be there.
        return vendorRepository.findById(vendorId).get();

    }

    @Override
    public List<CloudVendor> allVendor() {

        return vendorRepository.findAll();
    }
}
