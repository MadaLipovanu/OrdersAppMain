package com.bestapp.ordersapp;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class TestController {


    @GetMapping("/testAdmin")
    @PreAuthorize("hasRole('ROLE_RESTAURANT')")
    public ResponseEntity<?> testAdmin() {
        System.out.println("ADMIN");
        return new ResponseEntity<String>("admin", HttpStatus.OK);
    }



}
