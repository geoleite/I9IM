<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="arq_arquivoJB" class="br.com.i9.imagemanager.jb.Arq_arquivoConsultJB" scope="request"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="*"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="page" value="${pageContext}"/>                                         
${arq_arquivoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${arq_arquivoJB.list}" var="item">
     ,{	"pro_nr_id":"${item.pro_nr_id}"
 ,	"arq_nr_id":"${item.arq_nr_id}"
 ,	"cla_nr_id":"${item.cla_nr_id}"
 ,	"tid_nr_id":"${item.tid_nr_id}"
 ,	"arq_tx_nome":"${item.arq_tx_nome}"
 ,	"arq_tx_descricao":"${item.arq_tx_descricao}"
 ,	"arq_dt_cadastro":"<fmt:formatDate value="${item.arq_dt_cadastro}" pattern="dd/MM/yyyy"/>"
 ,	"arq_tx_situacao":"${item.arq_tx_situacao}"
 ,	"arq_dt_validadeinicio":"<fmt:formatDate value="${item.arq_dt_validadeinicio}" pattern="dd/MM/yyyy"/>"
 ,	"arq_dt_validadefim":"<fmt:formatDate value="${item.arq_dt_validadefim}" pattern="dd/MM/yyyy"/>"
 ,	"arq_tx_promocional":"${item.arq_tx_promocional}"
  }
</c:forEach>
]}                                                                                
   
