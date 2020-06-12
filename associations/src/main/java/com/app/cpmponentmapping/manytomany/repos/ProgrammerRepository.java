package com.app.cpmponentmapping.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.app.cpmponentmapping.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
