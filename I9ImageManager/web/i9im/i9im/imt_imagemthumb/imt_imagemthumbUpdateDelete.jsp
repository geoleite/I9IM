<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="imt_imagemthumbJB" class="br.com.i9.imagemanager.jb.Imt_imagemthumbUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="*"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="page" value="${pageContext}"/>                                         
${imt_imagemthumbJB.execute}                                         
                                                                                

<form name="imt_imagemthumb" action="portal.jsp" method="post" enctype="multipart/form-data" >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${imt_imagemthumbJB.tipoMsg}">${imt_imagemthumbJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('imt_imagemthumb', 'update' , '/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('imt_imagemthumb', 'delete' , '/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('imt_imagemthumb', 'consult', '/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('imt_imagemthumb', 'consult' , '/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
<br/>
<table width="600" align="left" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
    <table align="left" border="0" width="50%">
    		<tr>
	<td>
		<label>cd_arquivo:</label>
	</td>
	<td>
	    <select name="imt_imagemthumbT.cd_arquivo" onKeyPress="nextField(this, event)">
         	<c:forEach items="${imt_imagemthumbJB.listarq_arquivo}" var="item">
            	  <option value="${item.cd_arquivo}">${item.cd_arquivo}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>cd_produto:</label>
	</td>
	<td>
	    <select name="imt_imagemthumbT.cd_produto" onKeyPress="nextField(this, event)">
         	<c:forEach items="${imt_imagemthumbJB.listarq_arquivo}" var="item">
            	  <option value="${item.cd_produto}">${item.cd_produto}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		imt_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="imt_imagemthumbT.imt_nr_id" value="${imt_imagemthumbJB.imt_imagemthumbT.imt_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		imt_bt_thumb:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="file" name="imt_imagemthumbT.imt_bt_thumb" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="imt_imagemthumbUpdateDelete.jsp?op=downloadImage&imt_imagemthumbT.cd_arquivo=${imt_imagemthumbJB.imt_imagemthumbT.cd_arquivo}&imt_imagemthumbT.cd_produto=${imt_imagemthumbJB.imt_imagemthumbT.cd_produto}&imt_imagemthumbT.imt_nr_id=${imt_imagemthumbJB.imt_imagemthumbT.imt_nr_id}&"/>
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('imt_imagemthumb', 'update' , '/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('imt_imagemthumb', 'delete' , '/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('imt_imagemthumb', 'consult', '/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('imt_imagemthumb', 'consult' , '/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
