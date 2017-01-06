<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="imt_imagemthumbJB" class="br.com.i9.imagemanager.jb.Imt_imagemthumbConsultJB" scope="request"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="*"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="page" value="${pageContext}"/>                                         
${imt_imagemthumbJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${imt_imagemthumbJB.list}" var="item">
     ,{	"cd_arquivo":"${item.cd_arquivo}"
 ,	"cd_produto":"${item.cd_produto}"
 ,	"imt_nr_id":"${item.imt_nr_id}"
 ,	"imt_bt_thumb":"IMAGEM"
  }
</c:forEach>
]}                                                                                
   
