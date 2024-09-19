package com.example.demo_jour_2.controller;


import com.example.demo_jour_2.dto.DataRequest;
import com.example.demo_jour_2.dto.DataResponse;
import com.example.demo_jour_2.dto.PaymentRequest;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("payment")
public class PaymentController {

    @PostMapping("")
    public ResponseEntity<DataResponse> post(@Valid @RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(new DataResponse());
    }


}
