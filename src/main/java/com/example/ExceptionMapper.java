package com.example;

import javax.ws.rs.core.Response;

public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {
  @Override
  public Response toResponse(Exception exception) {
    exception.printStackTrace();
    return Response.status(500).build();
  }
}
