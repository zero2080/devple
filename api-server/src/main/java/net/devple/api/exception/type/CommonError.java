package net.devple.api.exception.type;

import lombok.Getter;
import net.devple.api.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonError implements ErrorCode {
  NOT_FOUND("C001", "Not Found", HttpStatus.NOT_FOUND),
  INTERNAL_SERVER_ERROR("C002", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
  BAD_REQUEST("C003", "Bad Request", HttpStatus.BAD_REQUEST),
  UNAUTHORIZED("C004", "Unauthorized", HttpStatus.UNAUTHORIZED),
  FORBIDDEN("C005", "Forbidden", HttpStatus.FORBIDDEN);

  private final String code;
  private final String message;
  private final HttpStatus status;

  CommonError(String code, String message, HttpStatus status) {
    this.code = code;
    this.message = message;
    this.status = status;
  }
}
