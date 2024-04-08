package com.pfplatform.service;

import com.pfplatform.model.CoursesModel;
import com.pfplatform.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesModel createCourses(CoursesModel coursesModel) {
        return coursesRepository.save(coursesModel);
    }

    public List<CoursesModel> getAllCourses() {
        return coursesRepository.findAll();
    }

    public CoursesModel getCoursesById(Long id) {
        Optional<CoursesModel> coursesOptional = coursesRepository.findById(id);
        return coursesOptional.orElse(null);
    }

    public CoursesModel updateCourses(Long id, CoursesModel coursesModel) {
        if (coursesRepository.existsById(id)) {
            coursesModel.setId(id);
            return coursesRepository.save(coursesModel);
        } else {
            return null;
        }
    }

    public void deleteCourses(Long id) {
        coursesRepository.deleteById(id);
    }
}
