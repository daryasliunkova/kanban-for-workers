package com.dsliunkova.kanbanforworkers.repositories;

import com.dsliunkova.kanbanforworkers.entities.HistoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryItemRepository extends CrudRepository<HistoryItem, Integer> {
}
