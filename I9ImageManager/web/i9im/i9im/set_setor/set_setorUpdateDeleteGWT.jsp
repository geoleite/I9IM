<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="set_setorJB" class="br.com.i9.imagemanager.jb.Set_setorUpdateDeleteNewJB" scope="request"/>
<jsp:setProperty name="set_setorJB" property="*"/>                                         
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>                                         
${set_setorJB.execute}                                         
{"resultado":
{"msg":"${set_setorJB.msg}",
     "set_setor":{	"set_nr_id":"${set_setorJB.set_setorT.set_nr_id}"
 ,	"set_tx_nome":"${set_setorJB.set_setorT.set_tx_nome}"
 ,	"set_tx_status":"${set_setorJB.set_setorT.set_tx_status}"
 ,	"set_nr_idsetorpai":"${set_setorJB.set_setorT.set_nr_idsetorpai}"
 ,	"set_tx_visivel":"${set_setorJB.set_setorT.set_tx_visivel}"
 ,	"emp_nr_id":"${set_setorJB.set_setorT.emp_nr_id}"
  }
    }
     
}                                                                                
   
