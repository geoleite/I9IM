<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_selJB" class="br.com.i9.imagemanager.jb.Pro_selConsultJB" scope="request"/>                                         
<jsp:setProperty name="pro_selJB" property="*"/>                                         
<jsp:setProperty name="pro_selJB" property="page" value="${pageContext}"/>                                         
${pro_selJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${pro_selJB.list}" var="item">
     ,{	"pro_nr_id":"${item.pro_nr_id}"
 ,	"sel_nr_id":"${item.sel_nr_id}"
  }
</c:forEach>
]}                                                                                
   
