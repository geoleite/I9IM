<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ond_ondaJB" class="br.com.i9.imagemanager.jb.Ond_ondaConsultJB" scope="request"/>                                         
<jsp:setProperty name="ond_ondaJB" property="*"/>                                         
<jsp:setProperty name="ond_ondaJB" property="page" value="${pageContext}"/>                                         
${ond_ondaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ond_ondaJB.list}" var="item">
     ,{	"eve_nr_id":"${item.eve_nr_id}"
 ,	"ond_nr_id":"${item.ond_nr_id}"
 ,	"ond_dt_criacao":"<fmt:formatDate value="${item.ond_dt_criacao}" pattern="dd/MM/yyyy HH:mm"/>"
  }
</c:forEach>
]}                                                                                
   
