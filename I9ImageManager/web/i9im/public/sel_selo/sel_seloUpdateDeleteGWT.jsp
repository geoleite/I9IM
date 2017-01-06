<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="sel_seloJB" class="br.com.i9.imagemanager.jb.Sel_seloUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sel_seloJB" property="*"/>                                         
<jsp:setProperty name="sel_seloJB" property="page" value="${pageContext}"/>                                         
${sel_seloJB.execute}                                         
{"resultado":
{"msg":"${sel_seloJB.msg}",
     "sel_selo":{	"sel_nr_id":"${sel_seloJB.sel_seloT.sel_nr_id}"
 ,	"cls_nr_id":"${sel_seloJB.sel_seloT.cls_nr_id}"
 ,	"tid_nr_id":"${sel_seloJB.sel_seloT.tid_nr_id}"
 ,	"sel_tx_nome":"${sel_seloJB.sel_seloT.sel_tx_nome}"
 ,	"sel_tx_descricao":"${sel_seloJB.sel_seloT.sel_tx_descricao}"
 ,	"sel_dt_cadastro":"<fmt:formatDate value="${sel_seloJB.sel_seloT.sel_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"sel_tx_situacao":"${sel_seloJB.sel_seloT.sel_tx_situacao}"
 ,	"sel_bt_arquivo":"IMAGEM"
 ,	"sel_dt_validadeinicio":"<fmt:formatDate value="${sel_seloJB.sel_seloT.sel_dt_validadeinicio}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"sel_dt_validadefim":"<fmt:formatDate value="${sel_seloJB.sel_seloT.sel_dt_validadefim}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"sel_tx_promocional":"${sel_seloJB.sel_seloT.sel_tx_promocional}"
  }
    }
     
}                                                                                
   
