<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="arq_arquivoJB" class="br.com.i9.imagemanager.jb.Arq_arquivoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="*"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="page" value="${pageContext}"/>                                         
${arq_arquivoJB.execute}                                         
{"resultado":
{"msg":"${arq_arquivoJB.msg}",
     "arq_arquivo":{	"cd_produto":"${arq_arquivoJB.arq_arquivoT.pro_nr_id}"
 ,	"arq_nr_id":"${arq_arquivoJB.arq_arquivoT.arq_nr_id}"
 ,	"cla_nr_id":"${arq_arquivoJB.arq_arquivoT.cla_nr_id}"
 ,	"tid_nr_id":"${arq_arquivoJB.arq_arquivoT.tid_nr_id}"
 ,	"arq_tx_nome":"${arq_arquivoJB.arq_arquivoT.arq_tx_nome}"
 ,	"arq_tx_descricao":"${arq_arquivoJB.arq_arquivoT.arq_tx_descricao}"
 ,	"arq_dt_cadastro":"<fmt:formatDate value="${arq_arquivoJB.arq_arquivoT.arq_dt_cadastro}" pattern="dd/MM/yyyy"/>"
 ,	"arq_tx_situacao":"${arq_arquivoJB.arq_arquivoT.arq_tx_situacao}"
 ,	"arq_bt_arquivo":"IMAGEM"
 ,	"arq_dt_validadeinicio":"<fmt:formatDate value="${arq_arquivoJB.arq_arquivoT.arq_dt_validadeinicio}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"arq_dt_validadefim":"<fmt:formatDate value="${arq_arquivoJB.arq_arquivoT.arq_dt_validadefim}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"arq_tx_promocional":"${arq_arquivoJB.arq_arquivoT.arq_tx_promocional}"
  }
    }
     
}                                                                                
   
