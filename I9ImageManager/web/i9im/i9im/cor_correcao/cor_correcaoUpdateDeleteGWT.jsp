<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cor_correcaoJB" class="br.com.i9.imagemanager.jb.Cor_correcaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cor_correcaoJB" property="*"/>                                         
<jsp:setProperty name="cor_correcaoJB" property="page" value="${pageContext}"/>                                         
${cor_correcaoJB.execute}                                         
{"resultado":
{"msg":"${cor_correcaoJB.msg}",
     "cor_correcao":{	"cor_nr_id":"${cor_correcaoJB.cor_correcaoT.cor_nr_id}"
 ,	"tic_nr_id":"${cor_correcaoJB.cor_correcaoT.tic_nr_id}"
 ,	"cor_tx_observacao":"${cor_correcaoJB.cor_correcaoT.cor_tx_observacao}"
 ,	"set_nr_id":"${cor_correcaoJB.cor_correcaoT.set_nr_id}"
 ,	"usu_nr_id":"${cor_correcaoJB.cor_correcaoT.usu_nr_id}"
 ,	"cor_tx_status":"${cor_correcaoJB.cor_correcaoT.cor_tx_status}"
 ,	"cor_nr_posx":"${cor_correcaoJB.cor_correcaoT.cor_nr_posx}"
 ,	"cor_nr_posy":"${cor_correcaoJB.cor_correcaoT.cor_nr_posy}"
 ,	"reg_nr_id":"${cor_correcaoJB.cor_correcaoT.reg_nr_id}"
 ,	"cor_dt_corrigido":"<fmt:formatDate value="${cor_correcaoJB.cor_correcaoT.cor_dt_corrigido}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"pag_nr_id":"${cor_correcaoJB.cor_correcaoT.pag_nr_id}"
  }
    }
     
}                                                                                
   
