package com.mtm.examples.ratelimiting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Manjunath M T
 * @since 09-Jun-2024
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