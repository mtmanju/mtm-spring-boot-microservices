package com.mtm.examples.examples.service;

import com.mtm.examples.examples.domain.SampleData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface SampleService {

    public Mono<SampleData> saveData(SampleData request);

    public Mono<Object> getData();

    public Mono<ResponseEntity<Object>> updateData();

    public Mono<ResponseEntity<Object>> deleteData();

    public Mono<ResponseEntity<Object>> calculateFOCharges(MultipartFile file);

}
