<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="reg_regiaoJB" class="br.com.i9.imagemanager.jb.Reg_regiaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="reg_regiaoJB" property="*"/>                                         
<jsp:setProperty name="reg_regiaoJB" property="page" value="${pageContext}"/>                                         
${reg_regiaoJB.execute}                                         
{"resultado":
{"msg":"${reg_regiaoJB.msg}",
     "reg_regiao":{	"reg_nr_id":"${reg_regiaoJB.reg_regiaoT.reg_nr_id}"
 ,	"reg_tx_nome":"${reg_regiaoJB.reg_regiaoT.reg_tx_nome}"
  }
    }
     
}                                                                                
   
