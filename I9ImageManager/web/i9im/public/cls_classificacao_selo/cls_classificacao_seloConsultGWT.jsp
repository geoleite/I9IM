<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cls_classificacao_seloJB" class="br.com.i9.imagemanager.jb.Cls_classificacao_seloConsultJB" scope="request"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="*"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="page" value="${pageContext}"/>                                         
${cls_classificacao_seloJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cls_classificacao_seloJB.list}" var="item">
     ,{	"cls_nr_id":"${item.cls_nr_id}"
 ,	"cls_tx_tipo":"${item.cls_tx_tipo}"
  }
</c:forEach>
]}                                                                                
   
