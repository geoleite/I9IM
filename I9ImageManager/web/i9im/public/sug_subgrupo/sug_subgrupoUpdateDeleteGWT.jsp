<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sug_subgrupoJB" class="br.com.i9.imagemanager.jb.Sug_subgrupoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="*"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="page" value="${pageContext}"/>                                         
${sug_subgrupoJB.execute}                                         
{"resultado":
{"msg":"${sug_subgrupoJB.msg}",
     "sug_subgrupo":{	"gru_nr_id":"${sug_subgrupoJB.sug_subgrupoT.gru_nr_id}"
 ,	"ses_nr_id":"${sug_subgrupoJB.sug_subgrupoT.ses_nr_id}"
 ,	"sug_nr_id":"${sug_subgrupoJB.sug_subgrupoT.sug_nr_id}"
 ,	"sug_tx_nome":"${sug_subgrupoJB.sug_subgrupoT.sug_tx_nome}"
 ,	"set_nr_id":"${sug_subgrupoJB.sug_subgrupoT.set_nr_id}"
  }
    }
     
}                                                                                
   
