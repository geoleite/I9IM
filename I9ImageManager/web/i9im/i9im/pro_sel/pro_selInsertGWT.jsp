<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pro_selJB" class="br.com.i9.imagemanager.jb.Pro_selInsertJB" scope="request"/>
<jsp:setProperty name="pro_selJB" property="*"/>
<jsp:setProperty name="pro_selJB" property="page" value="${pageContext}"/>
${pro_selJB.execute}
{"resultado":"${pro_selJB.msg}"}
