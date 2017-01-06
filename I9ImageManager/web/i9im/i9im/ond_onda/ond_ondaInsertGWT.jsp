<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ond_ondaJB" class="br.com.i9.imagemanager.jb.Ond_ondaInsertJB" scope="request"/>
<jsp:setProperty name="ond_ondaJB" property="*"/>
<jsp:setProperty name="ond_ondaJB" property="page" value="${pageContext}"/>
${ond_ondaJB.execute}
{"resultado":"${ond_ondaJB.msg}"}
