package com.event.custom_exception;

import java.time.LocalDateTime
;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {
	private String message;
	private LocalDateTime timeSatmp;
}
