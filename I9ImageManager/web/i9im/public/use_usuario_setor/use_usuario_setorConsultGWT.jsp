<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="use_usuario_setorJB" class="br.com.i9.imagemanager.jb.Use_usuario_setorConsultJB" scope="request"/>                                         
<jsp:setProperty name="use_usuario_setorJB" property="*"/>                                         
<jsp:setProperty name="use_usuario_setorJB" property="page" value="${pageContext}"/>                                         
${use_usuario_setorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${use_usuario_setorJB.list}" var="item">
     ,{	"usu_nr_id":"${item.usu_nr_id}"
 ,	"set_nr_id":"${item.set_nr_id}"
  }
</c:forEach>
]}                                                                                
   
