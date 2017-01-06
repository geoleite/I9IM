<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="use_usuario_setorJB" class="br.com.i9.imagemanager.jb.Use_usuario_setorInsertJB" scope="request"/>
<jsp:setProperty name="use_usuario_setorJB" property="*"/>
<jsp:setProperty name="use_usuario_setorJB" property="page" value="${pageContext}"/>
${use_usuario_setorJB.execute}
{"resultado":"${use_usuario_setorJB.msg}"}
