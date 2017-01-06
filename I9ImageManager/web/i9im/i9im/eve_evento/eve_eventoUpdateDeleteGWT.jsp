<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eve_eventoJB" class="br.com.i9.imagemanager.jb.Eve_eventoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="eve_eventoJB" property="*"/>                                         
<jsp:setProperty name="eve_eventoJB" property="page" value="${pageContext}"/>                                         
${eve_eventoJB.execute}                                         
{"resultado":
{"msg":"${eve_eventoJB.msg}",
     "eve_evento":{	"eve_nr_id":"${eve_eventoJB.eve_eventoT.eve_nr_id}"
 ,	"eve_tx_nome":"${eve_eventoJB.eve_eventoT.eve_tx_nome}"
 ,	"eve_dt_inicio":"<fmt:formatDate value="${eve_eventoJB.eve_eventoT.eve_dt_inicio}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"eve_dt_fim":"<fmt:formatDate value="${eve_eventoJB.eve_eventoT.eve_dt_fim}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"eve_dt_criacao":"<fmt:formatDate value="${eve_eventoJB.eve_eventoT.eve_dt_criacao}" pattern="dd/MM/yyyy HH:mm"/>"
 ,      "emp_nr_id":"${eve_eventoJB.eve_eventoT.emp_nr_id}"
  }
    }
     
}                                                                                
   
