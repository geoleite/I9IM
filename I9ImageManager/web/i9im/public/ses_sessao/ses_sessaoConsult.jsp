<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ses_sessaoJB" class="br.com.i9.imagemanager.jb.Ses_sessaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ses_sessaoJB" property="*"/>                                         
<jsp:setProperty name="ses_sessaoJB" property="page" value="${pageContext}"/>                                         
${ses_sessaoJB.execute}                                         
                                                                                

<form name="ses_sessao" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/ses_sessao/ses_sessaoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${ses_sessaoJB.tipoMsg}">${ses_sessaoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('ses_sessao','', '/i9im/public/ses_sessao/ses_sessaoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('ses_sessao','consult', '/i9im/public/ses_sessao/ses_sessaoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ses_sessaoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ses_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/ses_sessao/ses_sessaoUpdateDelete.jsp&op=findbyid&ses_sessaoT.ses_nr_id=${item.ses_nr_id}&">
      		<c:out value="${item.ses_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ses_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/ses_sessao/ses_sessaoUpdateDelete.jsp&op=findbyid&ses_sessaoT.ses_nr_id=${item.ses_nr_id}&">
      		<c:out value="${item.ses_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('ses_sessao','delete', '/i9im/public/ses_sessao/ses_sessaoConsult.jsp?ses_sessaoT.ses_nr_id=${item.ses_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
