package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.entity.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createVendor(CloudVendor cloudVendor);
    public  String updateVendor(CloudVendor cloudVendor);
    public  String deleteVendor(String vendorId);
    public  CloudVendor getVendorById(String vendorId);
    public List<CloudVendor> allVendor();
}
