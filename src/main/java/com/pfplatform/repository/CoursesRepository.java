package com.pfplatform.repository;

import com.pfplatform.model.CoursesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<CoursesModel, Long> {
}
