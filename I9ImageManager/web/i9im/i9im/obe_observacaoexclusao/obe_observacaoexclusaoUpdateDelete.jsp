<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="obe_observacaoexclusaoJB" class="br.com.i9.imagemanager.jb.Obe_observacaoexclusaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="*"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="page" value="${pageContext}"/>                                         
${obe_observacaoexclusaoJB.execute}                                         
                                                                                

<form name="obe_observacaoexclusao" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alterac�o ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${obe_observacaoexclusaoJB.tipoMsg}">${obe_observacaoexclusaoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('obe_observacaoexclusao', 'update' , '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('obe_observacaoexclusao', 'delete' , '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('obe_observacaoexclusao', 'consult', '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('obe_observacaoexclusao', 'consult' , '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp')" /-->

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
		<label>arq_nr_id:</label>
	</td>
	<td>
	    <select name="obe_observacaoexclusaoT.arq_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${obe_observacaoexclusaoJB.listarq_arquivo}" var="item">
            	  <option value="${item.arq_nr_id}">${item.arq_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		obe_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="obe_observacaoexclusaoT.obe_nr_id" value="${obe_observacaoexclusaoJB.obe_observacaoexclusaoT.obe_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>cd_produto:</label>
	</td>
	<td>
	    <select name="obe_observacaoexclusaoT.cd_produto" onKeyPress="nextField(this, event)">
         	<c:forEach items="${obe_observacaoexclusaoJB.listarq_arquivo}" var="item">
            	  <option value="${item.cd_produto}">${item.cd_produto}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		obe_tx_texto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="obe_observacaoexclusaoT.obe_tx_texto" value="${obe_observacaoexclusaoJB.obe_observacaoexclusaoT.obe_tx_texto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('obe_observacaoexclusao', 'update' , '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('obe_observacaoexclusao', 'delete' , '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('obe_observacaoexclusao', 'consult', '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('obe_observacaoexclusao', 'consult' , '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
