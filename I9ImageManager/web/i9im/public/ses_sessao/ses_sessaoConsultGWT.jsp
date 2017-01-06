<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ses_sessaoJB" class="br.com.i9.imagemanager.jb.Ses_sessaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ses_sessaoJB" property="*"/>                                         
<jsp:setProperty name="ses_sessaoJB" property="page" value="${pageContext}"/>                                         
${ses_sessaoJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${ses_sessaoJB.list}" var="item">
    ,{	"ses_nr_id":"${item.ses_nr_id}"
    ,	"set_nr_id":"${item.set_nr_id}"
    ,	"ses_tx_nome":"${item.ses_tx_nome}"
    }
</c:forEach>
]}                                                                                

