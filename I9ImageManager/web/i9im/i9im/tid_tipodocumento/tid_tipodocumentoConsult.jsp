<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="tid_tipodocumentoJB" class="br.com.i9.imagemanager.jb.Tid_tipodocumentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipodocumentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipodocumentoJB.execute}                                         
                                                                                

<form name="tid_tipodocumento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${tid_tipodocumentoJB.tipoMsg}">${tid_tipodocumentoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('tid_tipodocumento','', '/i9im/public/tid_tipodocumento/tid_tipodocumentoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('tid_tipodocumento','consult', '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${tid_tipodocumentoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Tid_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp&op=findbyid&tid_tipodocumentoT.tid_nr_id=${item.tid_nr_id}&">
      		<c:out value="${item.tid_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tid_tx_sigla" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp&op=findbyid&tid_tipodocumentoT.tid_nr_id=${item.tid_nr_id}&">
      		<c:out value="${item.tid_tx_sigla}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tid_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp&op=findbyid&tid_tipodocumentoT.tid_nr_id=${item.tid_nr_id}&">
      		<c:out value="${item.tid_tx_descricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tid_tx_reduzir" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/tid_tipodocumento/tid_tipodocumentoUpdateDelete.jsp&op=findbyid&tid_tipodocumentoT.tid_nr_id=${item.tid_nr_id}&">
      		<c:out value="${item.tid_tx_reduzir}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('tid_tipodocumento','delete', '/i9im/public/tid_tipodocumento/tid_tipodocumentoConsult.jsp?tid_tipodocumentoT.tid_nr_id=${item.tid_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
