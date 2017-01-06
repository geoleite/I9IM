<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cls_classificacao_seloJB" class="br.com.i9.imagemanager.jb.Cls_classificacao_seloConsultJB" scope="request"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="*"/>                                         
<jsp:setProperty name="cls_classificacao_seloJB" property="page" value="${pageContext}"/>                                         
${cls_classificacao_seloJB.execute}                                         
                                                                                

<form name="cls_classificacao_selo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${cls_classificacao_seloJB.tipoMsg}">${cls_classificacao_seloJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('cls_classificacao_selo','', '/i9im/public/cls_classificacao_selo/cls_classificacao_seloInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('cls_classificacao_selo','consult', '/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cls_classificacao_seloJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cls_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp&op=findbyid&cls_classificacao_seloT.cls_nr_id=${item.cls_nr_id}&">
      		<c:out value="${item.cls_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cls_tx_tipo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/cls_classificacao_selo/cls_classificacao_seloUpdateDelete.jsp&op=findbyid&cls_classificacao_seloT.cls_nr_id=${item.cls_nr_id}&">
      		<c:out value="${item.cls_tx_tipo}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('cls_classificacao_selo','delete', '/i9im/public/cls_classificacao_selo/cls_classificacao_seloConsult.jsp?cls_classificacao_seloT.cls_nr_id=${item.cls_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
