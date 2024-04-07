package com.mtm.examples.circuitbreaker.dto;

import lombok.*;

/**
 * @author Manjunath M T
 * @since 14-May-2023
 */
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