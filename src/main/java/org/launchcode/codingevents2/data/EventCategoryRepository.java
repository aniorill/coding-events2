package org.launchcode.codingevents2.data;

import org.launchcode.codingevents2.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository <EventCategory, Integer> {
}
