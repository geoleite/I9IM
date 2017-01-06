<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="enc_encarteJB" class="br.com.i9.imagemanager.jb.Enc_encarteInsertJB" scope="request"/>
<jsp:setProperty name="enc_encarteJB" property="*"/>
<jsp:setProperty name="enc_encarteJB" property="page" value="${pageContext}"/>
${enc_encarteJB.execute}
{"resultado":"${enc_encarteJB.msg}"}
