<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_eveJB" class="br.com.i9.imagemanager.jb.Pro_eveConsultJB" scope="request"/>                                         
<jsp:setProperty name="pro_eveJB" property="*"/>                                         
<jsp:setProperty name="pro_eveJB" property="page" value="${pageContext}"/>                                         
${pro_eveJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${pro_eveJB.list}" var="item">
     ,{	"pro_nr_id":"${item.pro_nr_id}"
 ,	"eve_nr_id":"${item.eve_nr_id}"
  }
</c:forEach>
]}                                                                                
   
