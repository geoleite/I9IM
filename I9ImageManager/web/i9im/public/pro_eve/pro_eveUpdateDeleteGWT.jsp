<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_eveJB" class="br.com.i9.imagemanager.jb.Pro_eveUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pro_eveJB" property="*"/>                                         
<jsp:setProperty name="pro_eveJB" property="page" value="${pageContext}"/>                                         
${pro_eveJB.execute}                                         
{"resultado":
{"msg":"${pro_eveJB.msg}",
     "pro_eve":{	"pro_nr_id":"${pro_eveJB.pro_eveT.pro_nr_id}"
 ,	"eve_nr_id":"${pro_eveJB.pro_eveT.eve_nr_id}"
  }
    }
     
}                                                                                
   
