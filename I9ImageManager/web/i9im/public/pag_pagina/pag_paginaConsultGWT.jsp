<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pag_paginaJB" class="br.com.i9.imagemanager.jb.Pag_paginaConsultJB" scope="request"/>                                         
<jsp:setProperty name="pag_paginaJB" property="*"/>                                         
<jsp:setProperty name="pag_paginaJB" property="page" value="${pageContext}"/>                                         
${pag_paginaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${pag_paginaJB.list}" var="item">
     ,{	"pag_nr_id":"${item.pag_nr_id}"
 ,	"enc_nr_id":"${item.enc_nr_id}"
 ,	"pag_tx_nome":"${item.pag_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
