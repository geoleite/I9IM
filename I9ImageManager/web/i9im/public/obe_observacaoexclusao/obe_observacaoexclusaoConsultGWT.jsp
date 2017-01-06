<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="obe_observacaoexclusaoJB" class="br.com.i9.imagemanager.jb.Obe_observacaoexclusaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="*"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="page" value="${pageContext}"/>                                         
${obe_observacaoexclusaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${obe_observacaoexclusaoJB.list}" var="item">
     ,{	"arq_nr_id":"${item.arq_nr_id}"
 ,	"obe_nr_id":"${item.obe_nr_id}"
 ,	"cd_produto":"${item.cd_produto}"
 ,	"obe_tx_texto":"${item.obe_tx_texto}"
  }
</c:forEach>
]}                                                                                
   
