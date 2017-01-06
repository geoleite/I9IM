<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cor_correcaoJB" class="br.com.i9.imagemanager.jb.Cor_correcaoInsertJB" scope="request"/>
<jsp:setProperty name="cor_correcaoJB" property="*"/>
<jsp:setProperty name="cor_correcaoJB" property="page" value="${pageContext}"/>
${cor_correcaoJB.execute}
{"resultado":"${cor_correcaoJB.msg}"}
