package com.example.springtransactionsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
public class SpringTransactionController {

    TransactionMethodService methodService;
    TransactionClassService classService;

    public SpringTransactionController(TransactionMethodService methodService, TransactionClassService classService) {
        this.methodService = methodService;
        this.classService = classService;
    }

    @GetMapping("/m-find")
    public List<Map<String, Object>> methodFind() {
        return methodService.findByEmp();
    }

    @GetMapping("/m-update")
    public void methodUpdate() {
        SpringTransactionEmp emp = new SpringTransactionEmp();
        emp.setId(UUID.randomUUID().toString());
        emp.setName(String.valueOf(new Random().nextInt(10)));
        methodService.updateEmp(emp);
    }

    @GetMapping("/c-find")
    public List<Map<String, Object>> classFind() {
        return classService.findByEmp();
    }

    @GetMapping("/c-update")
    public void classUpdate() {
        SpringTransactionEmp emp = new SpringTransactionEmp();
        emp.setId(UUID.randomUUID().toString());
        emp.setName(String.valueOf(new Random().nextInt(10)));
        classService.updateEmp(emp);
    }

}
