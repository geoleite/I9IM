<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pro_eveJB" class="br.com.i9.imagemanager.jb.Pro_eveInsertJB" scope="request"/>
<jsp:setProperty name="pro_eveJB" property="*"/>
<jsp:setProperty name="pro_eveJB" property="page" value="${pageContext}"/>
${pro_eveJB.execute}
{"resultado":"${pro_eveJB.msg}"}
