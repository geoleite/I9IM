<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="enc_encarteJB" class="br.com.i9.imagemanager.jb.Enc_encarteConsultJB" scope="request"/>                                         
<jsp:setProperty name="enc_encarteJB" property="*"/>                                         
<jsp:setProperty name="enc_encarteJB" property="page" value="${pageContext}"/>                                         
${enc_encarteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${enc_encarteJB.list}" var="item">
     ,{	"enc_nr_id":"${item.enc_nr_id}"
 ,	"enc_tx_nome":"${item.enc_tx_nome}"
 ,	"enc_dt_limite":"<fmt:formatDate value="${item.enc_dt_limite}" pattern="dd/MM/yyyy HH:mm:ss"/>"
 ,      "emp_nr_id":"${item.emp_nr_id}"
  }
</c:forEach>
]}                                                                                
   
