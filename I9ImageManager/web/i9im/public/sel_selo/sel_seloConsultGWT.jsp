<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sel_seloJB" class="br.com.i9.imagemanager.jb.Sel_seloConsultJB" scope="request"/>                                         
<jsp:setProperty name="sel_seloJB" property="*"/>                                         
<jsp:setProperty name="sel_seloJB" property="page" value="${pageContext}"/>                                         
${sel_seloJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${sel_seloJB.list}" var="item">
     ,{	"sel_nr_id":"${item.sel_nr_id}"
 ,	"cls_nr_id":"${item.cls_nr_id}"
 ,	"tid_nr_id":"${item.tid_nr_id}"
 ,	"sel_tx_nome":"${item.sel_tx_nome}"
 ,	"sel_tx_descricao":"${item.sel_tx_descricao}"
 ,	"sel_dt_cadastro":"<fmt:formatDate value="${item.sel_dt_cadastro}" pattern="dd/MM/yyyy"/>"
 ,	"sel_tx_situacao":"${item.sel_tx_situacao}"
 ,	"sel_bt_arquivo":"IMAGEM"
 ,	"sel_dt_validadeinicio":"<fmt:formatDate value="${item.sel_dt_validadeinicio}" pattern="dd/MM/yyyy"/>"
 ,	"sel_dt_validadefim":"<fmt:formatDate value="${item.sel_dt_validadefim}" pattern="dd/MM/yyyy"/>"
 ,	"sel_tx_promocional":"${item.sel_tx_promocional}"
  }
</c:forEach>
]}                                                                                
   
