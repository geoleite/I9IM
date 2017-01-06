<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pro_produtoJB" class="br.com.i9.imagemanager.jb.Pro_produtoInsertJB" scope="request"/>
<jsp:setProperty name="pro_produtoJB" property="*"/>
<jsp:setProperty name="pro_produtoJB" property="page" value="${pageContext}"/>
${pro_produtoJB.execute}
{"resultado":"${pro_produtoJB.msg}"}
