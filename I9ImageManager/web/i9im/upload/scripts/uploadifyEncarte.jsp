<%@page  import="org.apache.commons.fileupload.*" %>
<%@page  import="org.apache.commons.fileupload.servlet.*" %>
<%@page  import="org.apache.commons.fileupload.disk.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="uploadJB" class="br.com.i9.imagemanager.jb.Pag_paginaInsertJB" scope="request"/>
<jsp:setProperty name="uploadJB" property="*"/>
<jsp:setProperty name="uploadJB" property="page" value="${pageContext}"/>
${uploadJB.execute}