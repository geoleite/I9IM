<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="sug_subgrupoJB" class="br.com.i9.imagemanager.jb.Sug_subgrupoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="*"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="page" value="${pageContext}"/>                                         
${sug_subgrupoJB.execute}                                         
                                                                                

<form name="sug_subgrupo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alterac�o ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${sug_subgrupoJB.tipoMsg}">${sug_subgrupoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('sug_subgrupo', 'update' , '/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('sug_subgrupo', 'delete' , '/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('sug_subgrupo', 'consult', '/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('sug_subgrupo', 'consult' , '/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp')" /-->

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
		<label>gru_nr_id:</label>
	</td>
	<td>
	    <select name="sug_subgrupoT.gru_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${sug_subgrupoJB.listgru_grupo}" var="item">
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
	    <select name="sug_subgrupoT.ses_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${sug_subgrupoJB.listgru_grupo}" var="item">
            	  <option value="${item.ses_nr_id}">${item.ses_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		sug_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sug_subgrupoT.sug_nr_id" value="${sug_subgrupoJB.sug_subgrupoT.sug_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		sug_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="sug_subgrupoT.sug_tx_nome" value="${sug_subgrupoJB.sug_subgrupoT.sug_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>set_nr_id:</label>
	</td>
	<td>
	    <select name="sug_subgrupoT.set_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${sug_subgrupoJB.listset_setor}" var="item">
            	  <option value="${item.set_nr_id}">${item.set_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('sug_subgrupo', 'update' , '/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('sug_subgrupo', 'delete' , '/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('sug_subgrupo', 'consult', '/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('sug_subgrupo', 'consult' , '/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
