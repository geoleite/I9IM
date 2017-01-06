<%@page  import="org.apache.commons.fileupload.*" %>
<%@page  import="org.apache.commons.fileupload.servlet.*" %>
<%@page  import="org.apache.commons.fileupload.disk.*" %>
<%
            RequestContext rc = new ServletRequestContext(request);
            boolean isMultiPart = FileUpload.isMultipartContent(rc);
            System.out.println("Uploadif.jsp " + isMultiPart);

            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            String formulario = "";
            java.util.List items = upload.parseRequest(rc);
            java.util.Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                String paramName = item.getFieldName();
                if (!item.isFormField()) {
                    if (item.getName().length() > 0) {
                        System.out.println(item.getContentType());
                        System.out.println(item.getName());
                        byte[] paramValue = item.get();
                        System.out.println(paramValue.length);
                    }
                }
            }

%>