package com.pfplatform.controller;

import com.pfplatform.model.CustomersModel;
import com.pfplatform.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    // Endpoint para criar um novo usuário
    @PostMapping
    public ResponseEntity<CustomersModel> createCustomers(@RequestBody CustomersModel customersModel) {
        CustomersModel savedCustomersModel = customersService.createCustomers(customersModel);
        return new ResponseEntity<>(savedCustomersModel, HttpStatus.CREATED);
    }

    // Endpoint para recuperar todos os usuários
    @GetMapping
    public ResponseEntity<List<CustomersModel>> getAllCustomers() {
        List<CustomersModel> customersModels = customersService.getAllCustomers();
        return new ResponseEntity<>(customersModels, HttpStatus.OK);
    }

    // Endpoint para recuperar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomersModel> getCustomersById(@PathVariable Long id) {
        CustomersModel customersModel = customersService.getCustomersById(id);
        if (customersModel != null) {
            return new ResponseEntity<>(customersModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para atualizar um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<CustomersModel> updateCustomers(@PathVariable Long id, @RequestBody CustomersModel customersModel) {
        CustomersModel updatedCustomersModel = customersService.updateCustomers(id, customersModel);
        if (updatedCustomersModel != null) {
            return new ResponseEntity<>(updatedCustomersModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomers(@PathVariable Long id) {
        customersService.deleteCustomers(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
