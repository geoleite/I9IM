<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="sug_subgrupoJB" class="br.com.i9.imagemanager.jb.Sug_subgrupoInsertJB" scope="request"/>
<jsp:setProperty name="sug_subgrupoJB" property="*"/>
<jsp:setProperty name="sug_subgrupoJB" property="page" value="${pageContext}"/>
${sug_subgrupoJB.execute}
{"resultado":"${sug_subgrupoJB.msg}"}
