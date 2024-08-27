package com.skm.account.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {
	@Schema(
            description = "API path invoked by client"
    )
	private String apiPath;
	private HttpStatus statusCode;
	private LocalDateTime errorTime;
	private String errorDetail;

	public ErrorResponseDto(String apiPath, HttpStatus statusCode,  String errorDetail, LocalDateTime errorTime) {
		super();
		this.apiPath = apiPath;
		this.statusCode = statusCode;
		this.errorTime = errorTime;
		this.errorDetail = errorDetail;
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

}
