<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_selJB" class="br.com.i9.imagemanager.jb.Pro_selUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pro_selJB" property="*"/>                                         
<jsp:setProperty name="pro_selJB" property="page" value="${pageContext}"/>                                         
${pro_selJB.execute}                                         
{"resultado":
{"msg":"${pro_selJB.msg}",
     "pro_sel":{	"pro_nr_id":"${pro_selJB.pro_selT.pro_nr_id}"
 ,	"sel_nr_id":"${pro_selJB.pro_selT.sel_nr_id}"
  }
    }
     
}                                                                                
   
