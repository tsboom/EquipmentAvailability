package com.example;

import javax.ws.rs.core.Response;
/**
 * This class doesn't work, but it's an attempt to improve Jersey logging.
 */
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {
  @Override
  public Response toResponse(Exception exception) {
    exception.printStackTrace();
    return Response.status(500).build();
  }
}
