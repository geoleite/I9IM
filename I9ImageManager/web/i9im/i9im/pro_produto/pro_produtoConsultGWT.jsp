<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_produtoJB" class="br.com.i9.imagemanager.jb.Pro_produtoConsultJB" scope="request"/>                                         
<jsp:setProperty name="pro_produtoJB" property="*"/>                                         
<jsp:setProperty name="pro_produtoJB" property="page" value="${pageContext}"/>                                         
${pro_produtoJB.execute}                                         
{"resultado":[
{"registro":"${pro_produtoJB.count}"}
<c:forEach items="${pro_produtoJB.list}" var="item">
     ,{	"pro_nr_id":"${item.pro_nr_id}"
 ,	"pro_tx_nome":"${item.pro_tx_nome}"
 ,	"pro_nr_cdfamilia":"${item.pro_nr_cdfamilia}"
 ,	"pro_dt_atualizacao":"<fmt:formatDate value="${item.pro_dt_atualizacao}" pattern="dd/MM/yyyy"/>"
 ,	"pro_nr_valor":"${item.pro_nr_valor}"
 ,	"pro_tx_situacao":"${item.pro_tx_situacao}"
 ,	"set_nr_id":"${item.set_nr_id}"
 ,	"pro_tx_obs":"${item.pro_tx_obs}"
 ,	"pro_tx_idsap":"${item.pro_tx_idsap}"
  }
</c:forEach>
]}                                                                                
   
