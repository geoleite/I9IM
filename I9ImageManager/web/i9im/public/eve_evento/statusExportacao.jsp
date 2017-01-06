<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="status" class="br.com.i9.imagemanager.jb.ExportarEventoJB" scope="request"/>
<jsp:setProperty name="status" property="*"/>
<jsp:setProperty name="status" property="page" value="${pageContext}"/>
${status.execute}
{"resultado":"${status.percentual}"}