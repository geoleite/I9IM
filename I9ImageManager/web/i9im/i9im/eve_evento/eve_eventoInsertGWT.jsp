<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="eve_eventoJB" class="br.com.i9.imagemanager.jb.Eve_eventoInsertJB" scope="request"/>
<jsp:setProperty name="eve_eventoJB" property="*"/>
<jsp:setProperty name="eve_eventoJB" property="page" value="${pageContext}"/>
${eve_eventoJB.execute}
{"resultado":"${eve_eventoJB.msg}"}
