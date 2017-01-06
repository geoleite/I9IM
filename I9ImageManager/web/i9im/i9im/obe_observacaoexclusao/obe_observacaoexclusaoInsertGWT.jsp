<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="obe_observacaoexclusaoJB" class="br.com.i9.imagemanager.jb.Obe_observacaoexclusaoInsertJB" scope="request"/>
<jsp:setProperty name="obe_observacaoexclusaoJB" property="*"/>
<jsp:setProperty name="obe_observacaoexclusaoJB" property="page" value="${pageContext}"/>
${obe_observacaoexclusaoJB.execute}
{"resultado":"${obe_observacaoexclusaoJB.msg}"}
