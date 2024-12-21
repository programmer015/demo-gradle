package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
}
