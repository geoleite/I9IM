<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_produtoJB" class="br.com.i9.imagemanager.jb.Pro_produtoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pro_produtoJB" property="*"/>                                         
<jsp:setProperty name="pro_produtoJB" property="page" value="${pageContext}"/>                                         
${pro_produtoJB.execute}                                         
{"resultado":
{"msg":"${pro_produtoJB.msg}",
     "pro_produto":{	"pro_nr_id":"${pro_produtoJB.pro_produtoT.pro_nr_id}"
 ,	"pro_tx_nome":"${pro_produtoJB.pro_produtoT.pro_tx_nome}"
 ,	"pro_nr_cdfamilia":"${pro_produtoJB.pro_produtoT.pro_nr_cdfamilia}"
 ,	"pro_dt_atualizacao":"<fmt:formatDate value="${pro_produtoJB.pro_produtoT.pro_dt_atualizacao}" pattern="dd/MM/yyyy"/>"
 ,	"pro_nr_valor":"${pro_produtoJB.pro_produtoT.pro_nr_valor}"
 ,	"pro_tx_situacao":"${pro_produtoJB.pro_produtoT.pro_tx_situacao}"
 ,	"set_nr_id":"${pro_produtoJB.pro_produtoT.set_nr_id}"
 ,	"pro_tx_obs":"${pro_produtoJB.pro_produtoT.pro_tx_obs}"
 ,	"pro_tx_idsap":"${pro_produtoJB.pro_produtoT.pro_tx_idsap}"
  }
    }
     
}                                                                                
   
