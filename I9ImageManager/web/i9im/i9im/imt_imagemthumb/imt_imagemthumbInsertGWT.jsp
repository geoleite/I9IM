<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="imt_imagemthumbJB" class="br.com.i9.imagemanager.jb.Imt_imagemthumbInsertJB" scope="request"/>
<jsp:setProperty name="imt_imagemthumbJB" property="*"/>
<jsp:setProperty name="imt_imagemthumbJB" property="page" value="${pageContext}"/>
${imt_imagemthumbJB.execute}
{"resultado":"${imt_imagemthumbJB.msg}"}
