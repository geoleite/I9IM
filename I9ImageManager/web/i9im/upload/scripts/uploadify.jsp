<%@page  import="org.apache.commons.fileupload.*" %>
<%@page  import="org.apache.commons.fileupload.servlet.*" %>
<%@page  import="org.apache.commons.fileupload.disk.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="uploadJB" class="br.com.i9.imagemanager.jb.Arq_arquivoInsertJB" scope="request"/>
<jsp:setProperty name="uploadJB" property="*"/>
<jsp:setProperty name="uploadJB" property="page" value="${pageContext}"/>
${uploadJB.execute}
<%
/*
            RequestContext rc = new ServletRequestContext(request);
            boolean isMultiPart = FileUpload.isMultipartContent(rc);

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
*/
%>