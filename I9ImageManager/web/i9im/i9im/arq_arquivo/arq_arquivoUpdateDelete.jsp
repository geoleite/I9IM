<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="arq_arquivoJB" class="br.com.i9.imagemanager.jb.Arq_arquivoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="*"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="page" value="${pageContext}"/>                                         
${arq_arquivoJB.execute}                                         
                                                                                

<form name="arq_arquivo" action="portal.jsp" method="post" enctype="multipart/form-data" >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${arq_arquivoJB.tipoMsg}">${arq_arquivoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arq_arquivo', 'update' , '/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('arq_arquivo', 'delete' , '/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arq_arquivo', 'consult', '/i9im/public/arq_arquivo/arq_arquivoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('arq_arquivo', 'consult' , '/i9im/public/arq_arquivo/arq_arquivoConsult.jsp')" /-->

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
		<label>cd_produto:</label>
	</td>
	<td>
	    <select name="arq_arquivoT.cd_produto" onKeyPress="nextField(this, event)">
         	<c:forEach items="${arq_arquivoJB.listpro_produto}" var="item">
            	  <option value="${item.cd_produto}">${item.cd_produto}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		arq_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_nr_id" value="${arq_arquivoJB.arq_arquivoT.arq_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>cd_tipoimagem:</label>
	</td>
	<td>
	    <select name="arq_arquivoT.cd_tipoimagem" onKeyPress="nextField(this, event)">
         	<c:forEach items="${arq_arquivoJB.listcla_classificacao}" var="item">
            	  <option value="${item.cd_tipoimagem}">${item.cd_tipoimagem}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>cd_tipodocumento:</label>
	</td>
	<td>
	    <select name="arq_arquivoT.cd_tipodocumento" onKeyPress="nextField(this, event)">
         	<c:forEach items="${arq_arquivoJB.listtid_tipodocumento}" var="item">
            	  <option value="${item.cd_tipodocumento}">${item.cd_tipodocumento}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		arq_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_tx_nome" value="${arq_arquivoJB.arq_arquivoT.arq_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_tx_descricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_tx_descricao" value="${arq_arquivoJB.arq_arquivoT.arq_tx_descricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_dt_cadastro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_dt_cadastro" value="<fmt:formatDate value="${arq_arquivoJB.arq_arquivoT.arq_dt_cadastro}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_tx_situacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_tx_situacao" value="${arq_arquivoJB.arq_arquivoT.arq_tx_situacao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_bt_arquivo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="file" name="arq_arquivoT.arq_bt_arquivo" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="arq_arquivoUpdateDelete.jsp?op=downloadImage&arq_arquivoT.cd_produto=${arq_arquivoJB.arq_arquivoT.cd_produto}&arq_arquivoT.arq_nr_id=${arq_arquivoJB.arq_arquivoT.arq_nr_id}&"/>
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_dt_validadeinicio:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_dt_validadeinicio" value="<fmt:formatDate value="${arq_arquivoJB.arq_arquivoT.arq_dt_validadeinicio}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_dt_validadefim:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_dt_validadefim" value="<fmt:formatDate value="${arq_arquivoJB.arq_arquivoT.arq_dt_validadefim}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arq_tx_promocional:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arq_arquivoT.arq_tx_promocional" value="${arq_arquivoJB.arq_arquivoT.arq_tx_promocional}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arq_arquivo', 'update' , '/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('arq_arquivo', 'delete' , '/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arq_arquivo', 'consult', '/i9im/public/arq_arquivo/arq_arquivoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('arq_arquivo', 'consult' , '/i9im/public/arq_arquivo/arq_arquivoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
