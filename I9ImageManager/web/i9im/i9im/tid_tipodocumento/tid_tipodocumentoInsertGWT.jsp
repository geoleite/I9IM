<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tid_tipodocumentoJB" class="br.com.i9.imagemanager.jb.Tid_tipodocumentoInsertJB" scope="request"/>
<jsp:setProperty name="tid_tipodocumentoJB" property="*"/>
<jsp:setProperty name="tid_tipodocumentoJB" property="page" value="${pageContext}"/>
${tid_tipodocumentoJB.execute}
{"resultado":"${tid_tipodocumentoJB.msg}"}
