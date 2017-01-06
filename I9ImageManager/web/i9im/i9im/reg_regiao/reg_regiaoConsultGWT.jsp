<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="reg_regiaoJB" class="br.com.i9.imagemanager.jb.Reg_regiaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="reg_regiaoJB" property="*"/>                                         
<jsp:setProperty name="reg_regiaoJB" property="page" value="${pageContext}"/>                                         
${reg_regiaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${reg_regiaoJB.list}" var="item">
     ,{	"reg_nr_id":"${item.reg_nr_id}"
 ,	"reg_tx_nome":"${item.reg_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
