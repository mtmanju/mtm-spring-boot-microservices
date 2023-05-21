package com.mtm.examples.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
public class SampleData {

    private String identifier;
    private String name;
    private String description;
    private List<RestVariable> variables;

}
