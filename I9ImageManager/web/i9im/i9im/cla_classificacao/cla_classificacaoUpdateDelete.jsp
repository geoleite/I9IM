<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cla_classificacaoJB" class="br.com.i9.imagemanager.jb.Cla_classificacaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cla_classificacaoJB" property="*"/>                                         
<jsp:setProperty name="cla_classificacaoJB" property="page" value="${pageContext}"/>                                         
${cla_classificacaoJB.execute}                                         
                                                                                

<form name="cla_classificacao" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/cla_classificacao/cla_classificacaoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alterac�o ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${cla_classificacaoJB.tipoMsg}">${cla_classificacaoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cla_classificacao', 'update' , '/i9im/public/cla_classificacao/cla_classificacaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('cla_classificacao', 'delete' , '/i9im/public/cla_classificacao/cla_classificacaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cla_classificacao', 'consult', '/i9im/public/cla_classificacao/cla_classificacaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('cla_classificacao', 'consult' , '/i9im/public/cla_classificacao/cla_classificacaoConsult.jsp')" /-->

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
		cla_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cla_classificacaoT.cla_nr_id" value="${cla_classificacaoJB.cla_classificacaoT.cla_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cla_tx_tipo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cla_classificacaoT.cla_tx_tipo" value="${cla_classificacaoJB.cla_classificacaoT.cla_tx_tipo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cla_classificacao', 'update' , '/i9im/public/cla_classificacao/cla_classificacaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('cla_classificacao', 'delete' , '/i9im/public/cla_classificacao/cla_classificacaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('cla_classificacao', 'consult', '/i9im/public/cla_classificacao/cla_classificacaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('cla_classificacao', 'consult' , '/i9im/public/cla_classificacao/cla_classificacaoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
