<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="emp_empresaJB" class="br.com.i9.imagemanager.jb.Emp_empresaConsultJB" scope="request"/>                                         
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${emp_empresaJB.list}" var="item">
     ,{	"emp_nr_id":"${item.emp_nr_id}"
 ,	"emp_tx_nome":"${item.emp_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
