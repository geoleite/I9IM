<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="enc_encarteJB" class="br.com.i9.imagemanager.jb.Enc_encarteUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="enc_encarteJB" property="*"/>                                         
<jsp:setProperty name="enc_encarteJB" property="page" value="${pageContext}"/>                                         
${enc_encarteJB.execute}                                         
{"resultado":
{"msg":"${enc_encarteJB.msg}",
     "enc_encarte":{	"enc_nr_id":"${enc_encarteJB.enc_encarteT.enc_nr_id}"
     ,	"enc_tx_nome":"${enc_encarteJB.enc_encarteT.enc_tx_nome}"
 ,	"enc_dt_limite":"<fmt:formatDate value="${enc_encarteJB.enc_encarteT.enc_dt_limite}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"emp_nr_id":"${enc_encarteJB.enc_encarteT.emp_nr_id}"
  }
    }
     
}                                                                                
   
