<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="sel_seloJB" class="br.com.i9.imagemanager.jb.Sel_seloInsertJB" scope="request"/>
<jsp:setProperty name="sel_seloJB" property="*"/>
<jsp:setProperty name="sel_seloJB" property="page" value="${pageContext}"/>
${sel_seloJB.execute}
{"resultado":"${sel_seloJB.msg}"}
