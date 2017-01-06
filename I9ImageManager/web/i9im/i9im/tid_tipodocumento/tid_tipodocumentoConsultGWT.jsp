<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tid_tipodocumentoJB" class="br.com.i9.imagemanager.jb.Tid_tipodocumentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipodocumentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tid_tipodocumentoJB.list}" var="item">
     ,{	"tid_nr_id":"${item.tid_nr_id}"
 ,	"tid_tx_sigla":"${item.tid_tx_sigla}"
 ,	"tid_tx_descricao":"${item.tid_tx_descricao}"
 ,	"tid_tx_reduzir":"${item.tid_tx_reduzir}"
  }
</c:forEach>
]}                                                                                
   
