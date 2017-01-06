<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cor_correcaoJB" class="br.com.i9.imagemanager.jb.Cor_correcaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="cor_correcaoJB" property="*"/>                                         
<jsp:setProperty name="cor_correcaoJB" property="page" value="${pageContext}"/>                                         
${cor_correcaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cor_correcaoJB.list}" var="item">
     ,{	"cor_nr_id":"${item.cor_nr_id}"
 ,	"tic_nr_id":"${item.tic_nr_id}"
 ,	"cor_tx_observacao":"${item.cor_tx_observacao}"
 ,	"set_nr_id":"${item.set_nr_id}"
 ,	"usu_nr_id":"${item.usu_nr_id}"
 ,	"cor_tx_status":"${item.cor_tx_status}"
 ,	"cor_nr_posx":"${item.cor_nr_posx}"
 ,	"cor_nr_posy":"${item.cor_nr_posy}"
 ,	"cor_nr_posx2":"${item.cor_nr_posx2}"
 ,	"cor_nr_posy2":"${item.cor_nr_posy2}"
 ,	"reg_nr_id":"${item.reg_nr_id}"
 ,	"cor_dt_corrigido":"<fmt:formatDate value="${item.cor_dt_corrigido}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"pag_nr_id":"${item.pag_nr_id}"
  }
</c:forEach>
]}                                                                                
   
