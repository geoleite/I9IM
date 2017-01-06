<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tid_tipodocumentoJB" class="br.com.i9.imagemanager.jb.Tid_tipodocumentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipodocumentoJB.execute}                                         
                                                                                

<form name="tid_tipodocumento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${tid_tipodocumentoJB.tipoMsg}">${tid_tipodocumentoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('tid_tipodocumento', 'update' , '/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('tid_tipodocumento', 'delete' , '/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('tid_tipodocumento', 'consult', '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('tid_tipodocumento', 'consult' , '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')" /-->

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
		tid_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tid_tipodocumentoT.tid_nr_id" value="${tid_tipodocumentoJB.tid_tipodocumentoT.tid_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		tid_tx_sigla:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tid_tipodocumentoT.tid_tx_sigla" value="${tid_tipodocumentoJB.tid_tipodocumentoT.tid_tx_sigla}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		tid_tx_descricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tid_tipodocumentoT.tid_tx_descricao" value="${tid_tipodocumentoJB.tid_tipodocumentoT.tid_tx_descricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		tid_tx_reduzir:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tid_tipodocumentoT.tid_tx_reduzir" value="${tid_tipodocumentoJB.tid_tipodocumentoT.tid_tx_reduzir}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('tid_tipodocumento', 'update' , '/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('tid_tipodocumento', 'delete' , '/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('tid_tipodocumento', 'consult', '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('tid_tipodocumento', 'consult' , '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
