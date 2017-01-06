<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ond_ondaJB" class="br.com.i9.imagemanager.jb.Ond_ondaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ond_ondaJB" property="*"/>                                         
<jsp:setProperty name="ond_ondaJB" property="page" value="${pageContext}"/>                                         
${ond_ondaJB.execute}                                         
{"resultado":
{"msg":"${ond_ondaJB.msg}",
     "ond_onda":{	"eve_nr_id":"${ond_ondaJB.ond_ondaT.eve_nr_id}"
 ,	"ond_nr_id":"${ond_ondaJB.ond_ondaT.ond_nr_id}"
 ,	"ond_dt_criacao":"<fmt:formatDate value="${ond_ondaJB.ond_ondaT.ond_dt_criacao}" pattern="dd/MM/yyyy HH:mm"/>"
  }
    }
     
}                                                                                
   
