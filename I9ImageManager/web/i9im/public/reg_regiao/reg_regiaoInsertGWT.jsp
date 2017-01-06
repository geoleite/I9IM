<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="reg_regiaoJB" class="br.com.i9.imagemanager.jb.Reg_regiaoInsertJB" scope="request"/>
<jsp:setProperty name="reg_regiaoJB" property="*"/>
<jsp:setProperty name="reg_regiaoJB" property="page" value="${pageContext}"/>
${reg_regiaoJB.execute}
{"resultado":"${reg_regiaoJB.msg}"}
