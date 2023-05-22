package com.example.demo.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface VisitRepository
        extends JpaRepository<Visit, Long> {

//    Optional<AppUser> findByClientId(Long client_id);

//    @Transactional
//    @Modifying
//    @Query("UPDATE AppUser a " +
//            "SET a.enabled = TRUE WHERE a.email = ?1")
//    int enableAppUser(String email);

    @Query("SELECT v FROM Visit v WHERE v.client.id = :id")
    List<Visit> findByClientId(@Param("id") Long client_id);

    @Query("SELECT v FROM Visit v WHERE v.employee.id = :id")
    List<Visit> findByEmployeeId(@Param("id") Long employee_id);

    @Query("SELECT v FROM Visit v WHERE v.service.id = :id")
    List<Visit> findByServiceId(@Param("id") Long service_id);

}
