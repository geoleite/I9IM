<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="gru_grupoJB" class="br.com.i9.imagemanager.jb.Gru_grupoConsultJB" scope="request"/>                                         
<jsp:setProperty name="gru_grupoJB" property="*"/>                                         
<jsp:setProperty name="gru_grupoJB" property="page" value="${pageContext}"/>                                         
${gru_grupoJB.execute}                                         
                                                                                

<form name="gru_grupo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/gru_grupo/gru_grupoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${gru_grupoJB.tipoMsg}">${gru_grupoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('gru_grupo','', '/i9im/public/gru_grupo/gru_grupoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('gru_grupo','consult', '/i9im/public/gru_grupo/gru_grupoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${gru_grupoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Gru_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp&op=findbyid&gru_grupoT.gru_nr_id=${item.gru_nr_id}&gru_grupoT.ses_nr_id=${item.ses_nr_id}&">
      		<c:out value="${item.gru_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ses_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp&op=findbyid&gru_grupoT.gru_nr_id=${item.gru_nr_id}&gru_grupoT.ses_nr_id=${item.ses_nr_id}&">
      		<c:out value="${item.ses_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Gru_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/gru_grupo/gru_grupoUpdateDelete.jsp&op=findbyid&gru_grupoT.gru_nr_id=${item.gru_nr_id}&gru_grupoT.ses_nr_id=${item.ses_nr_id}&">
      		<c:out value="${item.gru_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('gru_grupo','delete', '/i9im/public/gru_grupo/gru_grupoConsult.jsp?gru_grupoT.gru_nr_id=${item.gru_nr_id}&gru_grupoT.ses_nr_id=${item.ses_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
