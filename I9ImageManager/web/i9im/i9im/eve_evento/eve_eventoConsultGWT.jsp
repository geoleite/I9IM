<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eve_eventoJB" class="br.com.i9.imagemanager.jb.Eve_eventoConsultJB" scope="request"/>                                         
<jsp:setProperty name="eve_eventoJB" property="*"/>                                         
<jsp:setProperty name="eve_eventoJB" property="page" value="${pageContext}"/>                                         
${eve_eventoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${eve_eventoJB.list}" var="item">
     ,{	"eve_nr_id":"${item.eve_nr_id}"
 ,	"eve_tx_nome":"${item.eve_tx_nome}"
 ,	"eve_dt_inicio":"<fmt:formatDate value="${item.eve_dt_inicio}" pattern="dd/MM/yyyy"/>"
 ,	"eve_dt_fim":"<fmt:formatDate value="${item.eve_dt_fim}" pattern="dd/MM/yyyy"/>"
 ,	"eve_dt_criacao":"<fmt:formatDate value="${item.eve_dt_criacao}" pattern="dd/MM/yyyy"/>"
 ,	"modificado":"${'S' eq eve_eventoJB.gerarNovaOnda[item.eve_nr_id]?'S':'N'}"
 ,      "emp_nr_id":"${item.emp_nr_id}"
  }
</c:forEach>
]}                                                                                
   
