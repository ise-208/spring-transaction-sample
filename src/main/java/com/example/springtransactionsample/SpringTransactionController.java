package com.example.springtransactionsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
public class SpringTransactionController {

    SpringTransactionService service;

    public SpringTransactionController(SpringTransactionService service) {
        this.service = service;
    }

    @GetMapping("/find")
    public List<Map<String, Object>> find() {
        return service.findByEmp();
    }

    @GetMapping("/update")
    public void update() {
        SpringTransactionEmp emp = new SpringTransactionEmp();
        emp.setId(UUID.randomUUID().toString());
        emp.setName(String.valueOf(new Random().nextInt(10)));
        service.updateEmp(emp);
    }

}
