<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="relatorioJB" class="br.com.i9.imagemanager.jb.RelatorioJB" scope="request"/>
<jsp:setProperty name="relatorioJB" property="*"/>
<jsp:setProperty name="relatorioJB" property="page" value="${pageContext}"/>
${relatorioJB.execute}
{"resultado":{
      "count":"${relatorioJB.qntImagens}",
      "produtos":"${relatorioJB.qntProdutos}"}
}
