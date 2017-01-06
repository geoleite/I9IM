<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gru_grupoJB" class="br.com.i9.imagemanager.jb.Gru_grupoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="gru_grupoJB" property="*"/>                                         
<jsp:setProperty name="gru_grupoJB" property="page" value="${pageContext}"/>                                         
${gru_grupoJB.execute}                                         
{"resultado":
{"msg":"${gru_grupoJB.msg}",
     "gru_grupo":{	"gru_nr_id":"${gru_grupoJB.gru_grupoT.gru_nr_id}"
 ,	"ses_nr_id":"${gru_grupoJB.gru_grupoT.ses_nr_id}"
 ,	"gru_tx_nome":"${gru_grupoJB.gru_grupoT.gru_tx_nome}"
  }
    }
     
}                                                                                
   
