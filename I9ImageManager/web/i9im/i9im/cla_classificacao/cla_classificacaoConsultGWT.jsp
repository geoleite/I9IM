<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cla_classificacaoJB" class="br.com.i9.imagemanager.jb.Cla_classificacaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="cla_classificacaoJB" property="*"/>                                         
<jsp:setProperty name="cla_classificacaoJB" property="page" value="${pageContext}"/>                                         
${cla_classificacaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cla_classificacaoJB.list}" var="item">
     ,{	"cla_nr_id":"${item.cla_nr_id}"
 ,	"cla_tx_tipo":"${item.cla_tx_tipo}"
  }
</c:forEach>
]}                                                                                
   
