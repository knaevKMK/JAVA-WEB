package com.project.shop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;
    protected Map<String, ?> errors;
    protected Page page;

    public Response() {
        this.timeStamp=LocalDateTime.now();
    }

    public Response(Page page) {
        this.page = page;
        this.timeStamp=LocalDateTime.now();
    }

    public Page getPage() {
        return page;
    }

    public Response setPage(Page page) {
        this.page = page;
        return this;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Response setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Response setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Response setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Response setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public Response setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public Map<?, ?> getData() {
        return data;
    }

    public Response setData(Map<?, ?> data) {
        this.data = data;
        return this;
    }

    public Map<String, ?> getErrors() {
        return errors;
    }

    public Response setErrors(Map<String, ?> errors) {
        this.errors = errors;
        return this;
    }

    public Response setBadRequestResponse(String type, Object request, Exception e, String msg) {
        this.setData(Map.of(type, request))
                .setErrors(Map.of("errors", e.getMessage()))
                .setMessage(msg)
                .setStatus(HttpStatus.BAD_REQUEST)
                .setStatusCode(HttpStatus.BAD_REQUEST.value());
        return this;
    }
    public Response setOkRequestResponse(String type, Object request, String msg) {
        this.setData(Map.of(type, request))
                .setMessage(msg)
                .setStatus(HttpStatus.OK)
                .setStatusCode(HttpStatus.OK.value());
        return this;
    }
}
