package com.fjdantas.cmcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fjdantas.cmcourse.domain.Client;

/*
 * ClientRepoitory Interface annotation by JpaRepository
 * interface of operation of data access by object type with id attribute for repository layer
 */

@Repository 
public interface ClientRepository extends JpaRepository<Client, Integer> { 

}
