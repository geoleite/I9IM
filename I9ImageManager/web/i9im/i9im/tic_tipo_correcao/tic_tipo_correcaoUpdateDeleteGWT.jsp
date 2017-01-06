<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tic_tipo_correcaoJB" class="br.com.i9.imagemanager.jb.Tic_tipo_correcaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tic_tipo_correcaoJB" property="*"/>                                         
<jsp:setProperty name="tic_tipo_correcaoJB" property="page" value="${pageContext}"/>                                         
${tic_tipo_correcaoJB.execute}                                         
{"resultado":
{"msg":"${tic_tipo_correcaoJB.msg}",
     "tic_tipo_correcao":{	"tic_nr_id":"${tic_tipo_correcaoJB.tic_tipo_correcaoT.tic_nr_id}"
 ,	"tic_tx_nome":"${tic_tipo_correcaoJB.tic_tipo_correcaoT.tic_tx_nome}"
  }
    }
     
}                                                                                
   
