<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="emp_empresaJB" class="br.com.i9.imagemanager.jb.Emp_empresaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
{"resultado":
{"msg":"${emp_empresaJB.msg}",
     "emp_empresa":{	"emp_nr_id":"${emp_empresaJB.emp_empresaT.emp_nr_id}"
 ,	"emp_tx_nome":"${emp_empresaJB.emp_empresaT.emp_tx_nome}"
  }
    }
     
}                                                                                
   
