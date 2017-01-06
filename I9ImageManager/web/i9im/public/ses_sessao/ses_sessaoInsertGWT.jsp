<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ses_sessaoJB" class="br.com.i9.imagemanager.jb.Ses_sessaoInsertJB" scope="request"/>
<jsp:setProperty name="ses_sessaoJB" property="*"/>
<jsp:setProperty name="ses_sessaoJB" property="page" value="${pageContext}"/>
${ses_sessaoJB.execute}
{"resultado":"${ses_sessaoJB.msg}"}
