package com.pfplatform.controller;

import com.pfplatform.model.CoursesModel;
import com.pfplatform.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    // Endpoint para criar um novo usuário
    @PostMapping
    public ResponseEntity<CoursesModel> createCourses(@RequestBody CoursesModel coursesModel) {
        CoursesModel savedCoursesModel = coursesService.createCourses(coursesModel);
        return new ResponseEntity<>(savedCoursesModel, HttpStatus.CREATED);
    }

    // Endpoint para recuperar todos os usuários
    @GetMapping
    public ResponseEntity<List<CoursesModel>> getAllCourses() {
        List<CoursesModel> coursesModels = coursesService.getAllCourses();
        return new ResponseEntity<>(coursesModels, HttpStatus.OK);
    }

    // Endpoint para recuperar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<CoursesModel> getCoursesById(@PathVariable Long id) {
        CoursesModel coursesModel = coursesService.getCoursesById(id);
        if (coursesModel != null) {
            return new ResponseEntity<>(coursesModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para atualizar um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<CoursesModel> updateCourses(@PathVariable Long id, @RequestBody CoursesModel coursesModel) {
        CoursesModel updatedCoursesModel = coursesService.updateCourses(id, coursesModel);
        if (updatedCoursesModel != null) {
            return new ResponseEntity<>(updatedCoursesModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourses(@PathVariable Long id) {
        coursesService.deleteCourses(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
