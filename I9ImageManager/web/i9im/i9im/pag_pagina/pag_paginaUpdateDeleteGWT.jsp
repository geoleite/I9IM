<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pag_paginaJB" class="br.com.i9.imagemanager.jb.Pag_paginaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pag_paginaJB" property="*"/>                                         
<jsp:setProperty name="pag_paginaJB" property="page" value="${pageContext}"/>                                         
${pag_paginaJB.execute}                                         
{"resultado":
{"msg":"${pag_paginaJB.msg}",
     "pag_pagina":{	"pag_nr_id":"${pag_paginaJB.pag_paginaT.pag_nr_id}"
 ,	"enc_nr_id":"${pag_paginaJB.pag_paginaT.enc_nr_id}"
  }
    }
     
}                                                                                
   
