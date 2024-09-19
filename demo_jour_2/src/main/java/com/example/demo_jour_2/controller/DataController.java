package com.example.demo_jour_2.controller;


import com.example.demo_jour_2.dto.DataRequest;
import com.example.demo_jour_2.dto.DataResponse;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class DataController {
    public ResponseEntity<DataResponse> post(@Valid @RequestBody DataRequest dataRequest) {
        return ResponseEntity.ok(new DataResponse());
    }

    public ResponseEntity<String> get() {
        String content = "<html><p></p></html>";
        return ResponseEntity.ok(StringEscapeUtils.escapeHtml4(content));
    }
}
