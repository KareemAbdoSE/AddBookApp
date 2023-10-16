package com.kareemabdolab1.Lab2.repository;

import com.kareemabdolab1.Lab2.BuddyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyInfoRepository extends JpaRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByPhoneNumber(String phoneNumber);

}