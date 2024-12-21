package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.StoreInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreInformationRepository extends CrudRepository<StoreInformation, Integer> {

    List<StoreInformation> findByName(String name);
    List<StoreInformation> findByAccountNumber(String accountNumber);
    List<StoreInformation> findByBalance(Integer balance);

}
