package com.dsliunkova.kanbanforworkers.repositories;

import com.dsliunkova.kanbanforworkers.entities.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends CrudRepository<Case, Integer> {
}
