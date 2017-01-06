<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="arq_arquivoJB" class="br.com.i9.imagemanager.jb.Arq_arquivoInsertJB" scope="request"/>
<jsp:setProperty name="arq_arquivoJB" property="*"/>
<jsp:setProperty name="arq_arquivoJB" property="page" value="${pageContext}"/>
${arq_arquivoJB.execute}
{"resultado":"${arq_arquivoJB.msg}"}
