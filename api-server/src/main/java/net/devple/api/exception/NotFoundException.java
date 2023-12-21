package net.devple.api.exception;

import net.devple.api.exception.type.CommonError;

public class NotFoundException extends BoardException{
  public NotFoundException() {
    super(CommonError.NOT_FOUND);
  }
}
