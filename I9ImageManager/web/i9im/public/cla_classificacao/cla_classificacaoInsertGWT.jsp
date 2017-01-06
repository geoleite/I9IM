<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cla_classificacaoJB" class="br.com.i9.imagemanager.jb.Cla_classificacaoInsertJB" scope="request"/>
<jsp:setProperty name="cla_classificacaoJB" property="*"/>
<jsp:setProperty name="cla_classificacaoJB" property="page" value="${pageContext}"/>
${cla_classificacaoJB.execute}
{"resultado":"${cla_classificacaoJB.msg}"}
