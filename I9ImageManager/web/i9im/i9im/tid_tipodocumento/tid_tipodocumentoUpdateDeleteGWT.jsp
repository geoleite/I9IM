<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tid_tipodocumentoJB" class="br.com.i9.imagemanager.jb.Tid_tipodocumentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipodocumentoJB.execute}                                         
{"resultado":
{"msg":"${tid_tipodocumentoJB.msg}",
     "tid_tipodocumento":{	"tid_nr_id":"${tid_tipodocumentoJB.tid_tipodocumentoT.tid_nr_id}"
 ,	"tid_tx_sigla":"${tid_tipodocumentoJB.tid_tipodocumentoT.tid_tx_sigla}"
 ,	"tid_tx_descricao":"${tid_tipodocumentoJB.tid_tipodocumentoT.tid_tx_descricao}"
 ,	"tid_tx_reduzir":"${tid_tipodocumentoJB.tid_tipodocumentoT.tid_tx_reduzir}"
  }
    }
     
}                                                                                
   
