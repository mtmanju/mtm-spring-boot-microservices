package com.mtm.examples.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ActivityDto {

    private String activity;
    private String type;
    private float participants;
    private float price;
    private String link;
    private String key;
    private float accessibility;

}
