<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="eve_eventoJB" class="br.com.i9.imagemanager.jb.Eve_eventoConsultJB" scope="request"/>                                         
<jsp:setProperty name="eve_eventoJB" property="*"/>                                         
<jsp:setProperty name="eve_eventoJB" property="page" value="${pageContext}"/>                                         
${eve_eventoJB.execute}                                         
                                                                                

<form name="eve_evento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/eve_evento/eve_eventoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${eve_eventoJB.tipoMsg}">${eve_eventoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('eve_evento','', '/i9im/public/eve_evento/eve_eventoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('eve_evento','consult', '/i9im/public/eve_evento/eve_eventoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${eve_eventoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Eve_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/eve_evento/eve_eventoUpdateDelete.jsp&op=findbyid&eve_eventoT.eve_nr_id=${item.eve_nr_id}&">
      		<c:out value="${item.eve_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eve_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/eve_evento/eve_eventoUpdateDelete.jsp&op=findbyid&eve_eventoT.eve_nr_id=${item.eve_nr_id}&">
      		<c:out value="${item.eve_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eve_dt_inicio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/eve_evento/eve_eventoUpdateDelete.jsp&op=findbyid&eve_eventoT.eve_nr_id=${item.eve_nr_id}&">
      		<fmt:formatDate value="${item.eve_dt_inicio}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eve_dt_fim" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/eve_evento/eve_eventoUpdateDelete.jsp&op=findbyid&eve_eventoT.eve_nr_id=${item.eve_nr_id}&">
      		<fmt:formatDate value="${item.eve_dt_fim}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eve_dt_criacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/eve_evento/eve_eventoUpdateDelete.jsp&op=findbyid&eve_eventoT.eve_nr_id=${item.eve_nr_id}&">
      		<fmt:formatDate value="${item.eve_dt_criacao}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('eve_evento','delete', '/i9im/public/eve_evento/eve_eventoConsult.jsp?eve_eventoT.eve_nr_id=${item.eve_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
