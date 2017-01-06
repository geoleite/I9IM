<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="sug_subgrupoJB" class="br.com.i9.imagemanager.jb.Sug_subgrupoConsultJB" scope="request"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="*"/>                                         
<jsp:setProperty name="sug_subgrupoJB" property="page" value="${pageContext}"/>                                         
${sug_subgrupoJB.execute}                                         
                                                                                

<form name="sug_subgrupo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${sug_subgrupoJB.tipoMsg}">${sug_subgrupoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('sug_subgrupo','', '/i9im/public/sug_subgrupo/sug_subgrupoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('sug_subgrupo','consult', '/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${sug_subgrupoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Gru_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp&op=findbyid&sug_subgrupoT.gru_nr_id=${item.gru_nr_id}&sug_subgrupoT.ses_nr_id=${item.ses_nr_id}&sug_subgrupoT.sug_nr_id=${item.sug_nr_id}&">
      		<c:out value="${item.gru_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ses_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp&op=findbyid&sug_subgrupoT.gru_nr_id=${item.gru_nr_id}&sug_subgrupoT.ses_nr_id=${item.ses_nr_id}&sug_subgrupoT.sug_nr_id=${item.sug_nr_id}&">
      		<c:out value="${item.ses_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sug_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp&op=findbyid&sug_subgrupoT.gru_nr_id=${item.gru_nr_id}&sug_subgrupoT.ses_nr_id=${item.ses_nr_id}&sug_subgrupoT.sug_nr_id=${item.sug_nr_id}&">
      		<c:out value="${item.sug_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sug_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp&op=findbyid&sug_subgrupoT.gru_nr_id=${item.gru_nr_id}&sug_subgrupoT.ses_nr_id=${item.ses_nr_id}&sug_subgrupoT.sug_nr_id=${item.sug_nr_id}&">
      		<c:out value="${item.sug_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Set_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sug_subgrupo/sug_subgrupoUpdateDelete.jsp&op=findbyid&sug_subgrupoT.gru_nr_id=${item.gru_nr_id}&sug_subgrupoT.ses_nr_id=${item.ses_nr_id}&sug_subgrupoT.sug_nr_id=${item.sug_nr_id}&">
      		<c:out value="${item.set_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('sug_subgrupo','delete', '/i9im/public/sug_subgrupo/sug_subgrupoConsult.jsp?sug_subgrupoT.gru_nr_id=${item.gru_nr_id}&sug_subgrupoT.ses_nr_id=${item.ses_nr_id}&sug_subgrupoT.sug_nr_id=${item.sug_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
