<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pro_eveJB" class="br.com.i9.imagemanager.jb.Pro_eveUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pro_eveJB" property="*"/>                                         
<jsp:setProperty name="pro_eveJB" property="page" value="${pageContext}"/>                                         
${pro_eveJB.execute}                                         
                                                                                

<form name="pro_eve" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/pro_eve/pro_eveUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${pro_eveJB.tipoMsg}">${pro_eveJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_eve', 'update' , '/i9im/public/pro_eve/pro_eveUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_eve', 'delete' , '/i9im/public/pro_eve/pro_eveUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_eve', 'consult', '/i9im/public/pro_eve/pro_eveConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('pro_eve', 'consult' , '/i9im/public/pro_eve/pro_eveConsult.jsp')" /-->

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
		<label>pro_nr_id:</label>
	</td>
	<td>
	    <select name="pro_eveT.pro_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pro_eveJB.listpro_produto}" var="item">
            	  <option value="${item.pro_nr_id}">${item.pro_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>eve_nr_id:</label>
	</td>
	<td>
	    <select name="pro_eveT.eve_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pro_eveJB.listeve_evento}" var="item">
            	  <option value="${item.eve_nr_id}">${item.eve_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_eve', 'update' , '/i9im/public/pro_eve/pro_eveUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_eve', 'delete' , '/i9im/public/pro_eve/pro_eveUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('pro_eve', 'consult', '/i9im/public/pro_eve/pro_eveConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('pro_eve', 'consult' , '/i9im/public/pro_eve/pro_eveConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
