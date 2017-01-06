<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cls_classificacao_seloJB" class="br.com.i9.imagemanager.jb.Cls_classificacao_seloUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="*"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="page" value="${pageContext}"/>                                         
${cls_classificacao_seloJB.execute}                                         
                                                                                

<form name="cls_classificacao_selo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${cls_classificacao_seloJB.tipoMsg}">${cls_classificacao_seloJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cls_classificacao_selo', 'update' , '/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('cls_classificacao_selo', 'delete' , '/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cls_classificacao_selo', 'consult', '/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('cls_classificacao_selo', 'consult' , '/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp')" /-->

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
	<td class="ms-standardheader">
		cls_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cls_classificacao_seloT.cls_nr_id" value="${cls_classificacao_seloJB.cls_classificacao_seloT.cls_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cls_tx_tipo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cls_classificacao_seloT.cls_tx_tipo" value="${cls_classificacao_seloJB.cls_classificacao_seloT.cls_tx_tipo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cls_classificacao_selo', 'update' , '/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('cls_classificacao_selo', 'delete' , '/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cls_classificacao_selo', 'consult', '/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('cls_classificacao_selo', 'consult' , '/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
