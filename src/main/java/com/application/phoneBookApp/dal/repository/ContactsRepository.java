package com.application.phoneBookApp.dal.repository;

import com.application.phoneBookApp.dal.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {
    @Query("select c from Contacts c " +
            "where upper(c.lastName) like upper(concat(?1, '%')) or upper(c.lastName) like upper(concat('%', ?1)) or upper(c.lastName) like upper(?1) " +
            "order by c.lastName")
    List<Contacts> findByLastNameStartsWithIgnoreCaseOrLastNameEndsWithIgnoreCaseOrLastNameLikeIgnoreCaseOrderByLastNameAsc(String lastName);
}