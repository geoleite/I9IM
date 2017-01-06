<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cor_correcaoJB" class="br.com.i9.imagemanager.jb.Uco_usuariocorrecaoConsultJB" scope="request"/>
<jsp:setProperty name="cor_correcaoJB" property="*"/>
<jsp:setProperty name="cor_correcaoJB" property="page" value="${pageContext}"/>
${cor_correcaoJB.execute}
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cor_correcaoJB.list}" var="item">
     ,{	"usu_nr_id":"${item.usu_nr_id}"
 ,	"usu_tx_nome":"${item.usu_tx_nome}"
 ,	"usu_tx_login":"${item.usu_tx_login}"
 ,	"usu_tx_status":"${item.usu_tx_status}"
 ,	"usu_tx_email":"${item.usu_tx_email}"
  }
</c:forEach>
]}

