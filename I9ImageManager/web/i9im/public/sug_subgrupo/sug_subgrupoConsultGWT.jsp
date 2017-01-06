<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sug_subgrupoJB" class="br.com.i9.imagemanager.jb.Sug_subgrupoConsultJB" scope="request"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="*"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="page" value="${pageContext}"/>                                         
${sug_subgrupoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${sug_subgrupoJB.list}" var="item">
     ,{	"gru_nr_id":"${item.gru_nr_id}"
 ,	"ses_nr_id":"${item.ses_nr_id}"
 ,	"sug_nr_id":"${item.sug_nr_id}"
 ,	"sug_tx_nome":"${item.sug_tx_nome}"
 ,	"set_nr_id":"${item.set_nr_id}"
  }
</c:forEach>
]}                                                                                
   
