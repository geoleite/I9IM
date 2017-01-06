<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cla_classificacaoJB" class="br.com.i9.imagemanager.jb.Cla_classificacaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cla_classificacaoJB" property="*"/>                                         
<jsp:setProperty name="cla_classificacaoJB" property="page" value="${pageContext}"/>                                         
${cla_classificacaoJB.execute}                                         
{"resultado":
{"msg":"${cla_classificacaoJB.msg}",
     "cla_classificacao":{	"cla_nr_id":"${cla_classificacaoJB.cla_classificacaoT.cla_nr_id}"
 ,	"cla_tx_tipo":"${cla_classificacaoJB.cla_classificacaoT.cla_tx_tipo}"
  }
    }
     
}                                                                                
   
