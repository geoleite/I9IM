<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tic_tipo_correcaoJB" class="br.com.i9.imagemanager.jb.Tic_tipo_correcaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="tic_tipo_correcaoJB" property="*"/>                                         
<jsp:setProperty name="tic_tipo_correcaoJB" property="page" value="${pageContext}"/>                                         
${tic_tipo_correcaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tic_tipo_correcaoJB.list}" var="item">
     ,{	"tic_nr_id":"${item.tic_nr_id}"
 ,	"tic_tx_nome":"${item.tic_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
