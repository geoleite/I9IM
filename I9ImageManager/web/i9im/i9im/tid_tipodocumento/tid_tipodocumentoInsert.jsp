<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tid_tipodocumentoJB" class="br.com.i9.imagemanager.jb.Tid_tipodocumentoInsertJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipodocumentoJB.execute}                                         
                                                                               
	
<form name="tid_tipodocumento" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/tid_tipodocumento/tid_tipodocumentoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${tid_tipodocumentoJB.tipoMsg}">${tid_tipodocumentoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('tid_tipodocumento','insert', '/i9im/public/tid_tipodocumento/tid_tipodocumentoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('tid_tipodocumento','Limpar', '/i9im/public/tid_tipodocumento/tid_tipodocumentoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('tid_tipodocumento','', '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')" />
    </div></td>
  </tr>
</table>
<br/>
<table align="left" width="600" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
	<table align="left" width="50%" border="0">
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
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('tid_tipodocumento','insert', '/i9im/public/tid_tipodocumento/tid_tipodocumentoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('tid_tipodocumento','Limpar', '/i9im/public/tid_tipodocumento/tid_tipodocumentoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('tid_tipodocumento','', '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
