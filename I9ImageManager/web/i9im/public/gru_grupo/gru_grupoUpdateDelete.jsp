<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="gru_grupoJB" class="br.com.i9.imagemanager.jb.Gru_grupoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="gru_grupoJB" property="*"/>                                         
<jsp:setProperty name="gru_grupoJB" property="page" value="${pageContext}"/>                                         
${gru_grupoJB.execute}                                         
                                                                                

<form name="gru_grupo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alterac�o ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${gru_grupoJB.tipoMsg}">${gru_grupoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('gru_grupo', 'update' , '/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('gru_grupo', 'delete' , '/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('gru_grupo', 'consult', '/i9im/public/gru_grupo/gru_grupoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('gru_grupo', 'consult' , '/i9im/public/gru_grupo/gru_grupoConsult.jsp')" /-->

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
		gru_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="gru_grupoT.gru_nr_id" value="${gru_grupoJB.gru_grupoT.gru_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>ses_nr_id:</label>
	</td>
	<td>
	    <select name="gru_grupoT.ses_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${gru_grupoJB.listses_sessao}" var="item">
            	  <option value="${item.ses_nr_id}">${item.ses_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		gru_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="gru_grupoT.gru_tx_nome" value="${gru_grupoJB.gru_grupoT.gru_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('gru_grupo', 'update' , '/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('gru_grupo', 'delete' , '/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('gru_grupo', 'consult', '/i9im/public/gru_grupo/gru_grupoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('gru_grupo', 'consult' , '/i9im/public/gru_grupo/gru_grupoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
