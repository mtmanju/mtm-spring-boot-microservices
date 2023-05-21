package com.mtm.examples.controller;

import com.mtm.examples.domain.SampleData;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RequestMapping(value = "/mtm/examples")
public interface SampleController {

    @PostMapping()
    public Mono<ResponseEntity<Object>> saveData(@RequestBody SampleData request);

    @GetMapping()
    public Mono<ResponseEntity<Object>> getCompleteData();

    @GetMapping("/{identifier}")
    public Mono<ResponseEntity<Object>> getData(@PathParam(value = "identifier") String identifier);

    @PutMapping("/{identifier}")
    public Mono<ResponseEntity<Object>> updateData(@PathParam(value = "identifier") String identifier,
                                                   @RequestBody SampleData request);

    @DeleteMapping("/{identifier}")
    public Mono<ResponseEntity<Object>> deleteData(@PathParam(value = "identifier") String identifier);

    @PostMapping("/calculate-charges")
    public Mono<ResponseEntity<Object>> calculateFuturesOptionsCharges(
            @RequestPart(name = "file", required = true) MultipartFile file);
}
