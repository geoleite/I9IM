<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="obe_observacaoexclusaoJB" class="br.com.i9.imagemanager.jb.Obe_observacaoexclusaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="*"/>                                         
<jsp:setProperty name="obe_observacaoexclusaoJB" property="page" value="${pageContext}"/>                                         
${obe_observacaoexclusaoJB.execute}                                         
                                                                                

<form name="obe_observacaoexclusao" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${obe_observacaoexclusaoJB.tipoMsg}">${obe_observacaoexclusaoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('obe_observacaoexclusao','', '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('obe_observacaoexclusao','consult', '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${obe_observacaoexclusaoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Arq_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp&op=findbyid&obe_observacaoexclusaoT.arq_nr_id=${item.arq_nr_id}&obe_observacaoexclusaoT.obe_nr_id=${item.obe_nr_id}&obe_observacaoexclusaoT.cd_produto=${item.cd_produto}&">
      		<c:out value="${item.arq_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obe_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp&op=findbyid&obe_observacaoexclusaoT.arq_nr_id=${item.arq_nr_id}&obe_observacaoexclusaoT.obe_nr_id=${item.obe_nr_id}&obe_observacaoexclusaoT.cd_produto=${item.cd_produto}&">
      		<c:out value="${item.obe_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cd_produto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp&op=findbyid&obe_observacaoexclusaoT.arq_nr_id=${item.arq_nr_id}&obe_observacaoexclusaoT.obe_nr_id=${item.obe_nr_id}&obe_observacaoexclusaoT.cd_produto=${item.cd_produto}&">
      		<c:out value="${item.cd_produto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obe_tx_texto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoUpdateDelete.jsp&op=findbyid&obe_observacaoexclusaoT.arq_nr_id=${item.arq_nr_id}&obe_observacaoexclusaoT.obe_nr_id=${item.obe_nr_id}&obe_observacaoexclusaoT.cd_produto=${item.cd_produto}&">
      		<c:out value="${item.obe_tx_texto}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('obe_observacaoexclusao','delete', '/i9im/public/obe_observacaoexclusao/obe_observacaoexclusaoConsult.jsp?obe_observacaoexclusaoT.arq_nr_id=${item.arq_nr_id}&obe_observacaoexclusaoT.obe_nr_id=${item.obe_nr_id}&obe_observacaoexclusaoT.cd_produto=${item.cd_produto}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
