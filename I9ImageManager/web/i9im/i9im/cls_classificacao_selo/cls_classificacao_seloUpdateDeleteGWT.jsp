<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cls_classificacao_seloJB" class="br.com.i9.imagemanager.jb.Cls_classificacao_seloUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="*"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="page" value="${pageContext}"/>                                         
${cls_classificacao_seloJB.execute}                                         
{"resultado":
{"msg":"${cls_classificacao_seloJB.msg}",
     "cls_classificacao_selo":{	"cls_nr_id":"${cls_classificacao_seloJB.cls_classificacao_seloT.cls_nr_id}"
 ,	"cls_tx_tipo":"${cls_classificacao_seloJB.cls_classificacao_seloT.cls_tx_tipo}"
  }
    }
     
}                                                                                
   
