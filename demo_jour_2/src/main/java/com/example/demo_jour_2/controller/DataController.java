package com.example.demo_jour_2.controller;


import com.example.demo_jour_2.dto.DataRequest;
import com.example.demo_jour_2.dto.DataResponse;
import com.example.demo_jour_2.service.SynchroneService;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class DataController {

    private final SynchroneService synchroneService;

    public DataController(SynchroneService synchroneService) {
        this.synchroneService = synchroneService;
    }

    @GetMapping("add/{data}")
    public ResponseEntity<String> post(@PathVariable String data) {
        synchroneService.addData(data);
        return ResponseEntity.ok("ok");

    }


    public ResponseEntity<DataResponse> post(@Valid @RequestBody DataRequest dataRequest) {
        return ResponseEntity.ok(new DataResponse());
    }

    public ResponseEntity<String> get() {
        String content = "<html><p></p></html>";
        return ResponseEntity.ok(StringEscapeUtils.escapeHtml4(content));
    }
}
