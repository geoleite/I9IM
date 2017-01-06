<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pro_produtoJB" class="br.com.i9.imagemanager.jb.Pro_produtoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pro_produtoJB" property="*"/>                                         
<jsp:setProperty name="pro_produtoJB" property="page" value="${pageContext}"/>                                         
${pro_produtoJB.execute}                                         
                                                                                

<form name="pro_produto" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${pro_produtoJB.tipoMsg}">${pro_produtoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_produto', 'update' , '/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_produto', 'delete' , '/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_produto', 'consult', '/i9im/public/pro_produto/pro_produtoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('pro_produto', 'consult' , '/i9im/public/pro_produto/pro_produtoConsult.jsp')" /-->

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
		pro_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_nr_id" value="${pro_produtoJB.pro_produtoT.pro_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		pro_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_tx_nome" value="${pro_produtoJB.pro_produtoT.pro_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		pro_nr_cdfamilia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_nr_cdfamilia" value="${pro_produtoJB.pro_produtoT.pro_nr_cdfamilia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		pro_dt_atualizacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_dt_atualizacao" value="<fmt:formatDate value="${pro_produtoJB.pro_produtoT.pro_dt_atualizacao}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		pro_nr_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_nr_valor" value="${pro_produtoJB.pro_produtoT.pro_nr_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		pro_tx_situacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_tx_situacao" value="${pro_produtoJB.pro_produtoT.pro_tx_situacao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>gru_nr_id:</label>
	</td>
	<td>
	    <select name="pro_produtoT.gru_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pro_produtoJB.listsug_subgrupo}" var="item">
            	  <option value="${item.gru_nr_id}">${item.gru_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>ses_nr_id:</label>
	</td>
	<td>
	    <select name="pro_produtoT.ses_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pro_produtoJB.listsug_subgrupo}" var="item">
            	  <option value="${item.ses_nr_id}">${item.ses_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>sug_nr_id:</label>
	</td>
	<td>
	    <select name="pro_produtoT.sug_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pro_produtoJB.listsug_subgrupo}" var="item">
            	  <option value="${item.sug_nr_id}">${item.sug_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		pro_tx_obs:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="pro_produtoT.pro_tx_obs" value="${pro_produtoJB.pro_produtoT.pro_tx_obs}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_produto', 'update' , '/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_produto', 'delete' , '/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_produto', 'consult', '/i9im/public/pro_produto/pro_produtoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('pro_produto', 'consult' , '/i9im/public/pro_produto/pro_produtoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
