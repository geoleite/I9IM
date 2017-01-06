<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="gru_grupoJB" class="br.com.i9.imagemanager.jb.Gru_grupoInsertJB" scope="request"/>
<jsp:setProperty name="gru_grupoJB" property="*"/>
<jsp:setProperty name="gru_grupoJB" property="page" value="${pageContext}"/>
${gru_grupoJB.execute}
{"resultado":"${gru_grupoJB.msg}"}
