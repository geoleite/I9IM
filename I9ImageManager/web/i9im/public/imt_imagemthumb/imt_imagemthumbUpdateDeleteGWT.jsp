<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="imt_imagemthumbJB" class="br.com.i9.imagemanager.jb.Imt_imagemthumbUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="*"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="page" value="${pageContext}"/>                                         
${imt_imagemthumbJB.execute}                                         
{"resultado":
{"msg":"${imt_imagemthumbJB.msg}",
     "imt_imagemthumb":{	"cd_arquivo":"${imt_imagemthumbJB.imt_imagemthumbT.cd_arquivo}"
 ,	"cd_produto":"${imt_imagemthumbJB.imt_imagemthumbT.cd_produto}"
 ,	"imt_nr_id":"${imt_imagemthumbJB.imt_imagemthumbT.imt_nr_id}"
 ,	"imt_bt_thumb":"IMAGEM"
  }
    }
     
}                                                                                
   
