<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="sel_seloJB" class="br.com.i9.imagemanager.jb.Sel_seloInsertJB" scope="request"/>                                         
<jsp:setProperty name="sel_seloJB" property="*"/>                                         
<jsp:setProperty name="sel_seloJB" property="page" value="${pageContext}"/>                                         
${sel_seloJB.execute}                                         
                                                                               
	
<form name="sel_selo" action="portal.jsp" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/sel_selo/sel_seloInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${sel_seloJB.tipoMsg}">${sel_seloJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('sel_selo','insert', '/i9im/public/sel_selo/sel_seloInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('sel_selo','Limpar', '/i9im/public/sel_selo/sel_seloInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('sel_selo','', '/i9im/public/sel_selo/sel_seloConsult.jsp')" />
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
	<td>
		<label>cls_nr_id:</label>
	</td>
	<td>
	    <select name="sel_seloT.cls_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${sel_seloJB.listcls_classificacao_selo}" var="item">
            	  <option value="${item.cls_nr_id}">${item.cls_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>tid_nr_id:</label>
	</td>
	<td>
	    <select name="sel_seloT.tid_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${sel_seloJB.listtid_tipodocumento}" var="item">
            	  <option value="${item.tid_nr_id}">${item.tid_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		sel_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_tx_nome" value="${sel_seloJB.sel_seloT.sel_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_tx_descricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_tx_descricao" value="${sel_seloJB.sel_seloT.sel_tx_descricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_dt_cadastro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_dt_cadastro" value="<fmt:formatDate value="${sel_seloJB.sel_seloT.sel_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_tx_situacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_tx_situacao" value="${sel_seloJB.sel_seloT.sel_tx_situacao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_bt_arquivo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="file" name="sel_seloT.sel_bt_arquivo" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="sel_seloUpdateDelete.jsp?op=downloadImage&sel_seloT.sel_nr_id=${sel_seloJB.sel_seloT.sel_nr_id}&"/>
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_dt_validadeinicio:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_dt_validadeinicio" value="<fmt:formatDate value="${sel_seloJB.sel_seloT.sel_dt_validadeinicio}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_dt_validadefim:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_dt_validadefim" value="<fmt:formatDate value="${sel_seloJB.sel_seloT.sel_dt_validadefim}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sel_tx_promocional:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sel_seloT.sel_tx_promocional" value="${sel_seloJB.sel_seloT.sel_tx_promocional}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('sel_selo','insert', '/i9im/public/sel_selo/sel_seloInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('sel_selo','Limpar', '/i9im/public/sel_selo/sel_seloInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('sel_selo','', '/i9im/public/sel_selo/sel_seloConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
