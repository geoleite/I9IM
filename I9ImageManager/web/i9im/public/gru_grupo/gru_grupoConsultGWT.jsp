<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gru_grupoJB" class="br.com.i9.imagemanager.jb.Gru_grupoConsultJB" scope="request"/>                                         
<jsp:setProperty name="gru_grupoJB" property="*"/>                                         
<jsp:setProperty name="gru_grupoJB" property="page" value="${pageContext}"/>                                         
${gru_grupoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${gru_grupoJB.list}" var="item">
     ,{	"gru_nr_id":"${item.gru_nr_id}"
 ,	"ses_nr_id":"${item.ses_nr_id}"
 ,	"gru_tx_nome":"${item.gru_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
