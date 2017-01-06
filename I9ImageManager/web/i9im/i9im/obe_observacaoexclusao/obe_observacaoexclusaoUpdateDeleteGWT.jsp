<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="obe_observacaoexclusaoJB" class="br.com.i9.imagemanager.jb.Obe_observacaoexclusaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="*"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="page" value="${pageContext}"/>                                         
${obe_observacaoexclusaoJB.execute}                                         
{"resultado":
{"msg":"${obe_observacaoexclusaoJB.msg}",
     "obe_observacaoexclusao":{	"arq_nr_id":"${obe_observacaoexclusaoJB.obe_observacaoexclusaoT.arq_nr_id}"
 ,	"obe_nr_id":"${obe_observacaoexclusaoJB.obe_observacaoexclusaoT.obe_nr_id}"
 ,	"cd_produto":"${obe_observacaoexclusaoJB.obe_observacaoexclusaoT.cd_produto}"
 ,	"obe_tx_texto":"${obe_observacaoexclusaoJB.obe_observacaoexclusaoT.obe_tx_texto}"
  }
    }
     
}                                                                                
   
