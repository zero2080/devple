package net.devple.api.exception;

import org.springframework.http.HttpStatus;

public class BoardException extends RuntimeException implements ErrorCode {
  private final HttpStatus status;
  private final String errorCode;

  protected BoardException(ErrorCode errorCode) {
    this(null, errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage());
  }

  private BoardException(Throwable cause, HttpStatus status, String errorCode, String errorMessage) {
    super(errorMessage, cause);
    this.status = status;
    this.errorCode = errorCode;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getCode() {
    return errorCode;
  }

}
