<%  response.setContentType("application/zip");
    response.setHeader("Content-Disposition", ";filename=\"i9.zip\"");
    response.getOutputStream().write("teste".getBytes());
    response.getOutputStream().flush();
    response.getOutputStream().close();%>