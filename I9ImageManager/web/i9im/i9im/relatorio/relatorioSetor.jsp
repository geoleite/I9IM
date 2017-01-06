<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="relatorioJB" class="br.com.i9.imagemanager.jb.RelatorioSetorJB" scope="request"/>
<jsp:setProperty name="relatorioJB" property="*"/>
<jsp:setProperty name="relatorioJB" property="page" value="${pageContext}"/>
${relatorioJB.execute}
{"resultado":[
   {"registro":"marcacao"}
   <c:forEach items="${relatorioJB.listSet}" var="item">
     ,{	"set_nr_id":"${item.set_nr_id}"
     ,	"set_tx_nome":"${item.set_tx_nome}"
     ,	"produtos":"${relatorioJB.quantidadesProdutoSetor[item.set_nr_id]}"
     ,	"produtosAfetados":"${relatorioJB.quantProdutoSetorImg[item.set_nr_id]}"
     ,	"quantidade":"${relatorioJB.quantidadesSetor[item.set_nr_id]}"
  }
</c:forEach>
]}
