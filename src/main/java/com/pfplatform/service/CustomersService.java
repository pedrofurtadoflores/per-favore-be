package com.pfplatform.service;

import com.pfplatform.model.CustomersModel;
import com.pfplatform.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public CustomersModel createCustomers(CustomersModel customersModel) {
        return customersRepository.save(customersModel);
    }

    public List<CustomersModel> getAllCustomers() {
        return customersRepository.findAll();
    }

    public CustomersModel getCustomersById(Long id) {
        Optional<CustomersModel> customersOptional = customersRepository.findById(id);
        return customersOptional.orElse(null);
    }

    public CustomersModel updateCustomers(Long id, CustomersModel customersModel) {
        if (customersRepository.existsById(id)) {
            customersModel.setId(id);
            return customersRepository.save(customersModel);
        } else {
            return null;
        }
    }

    public void deleteCustomers(Long id) {
        customersRepository.deleteById(id);
    }
}
