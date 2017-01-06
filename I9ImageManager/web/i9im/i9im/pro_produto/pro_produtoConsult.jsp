<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="pro_produtoJB" class="br.com.i9.imagemanager.jb.Pro_produtoConsultJB" scope="request"/>                                         
<jsp:setProperty name="pro_produtoJB" property="*"/>                                         
<jsp:setProperty name="pro_produtoJB" property="page" value="${pageContext}"/>                                         
${pro_produtoJB.execute}                                         
                                                                                

<form name="pro_produto" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/pro_produto/pro_produtoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${pro_produtoJB.tipoMsg}">${pro_produtoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('pro_produto','', '/i9im/public/pro_produto/pro_produtoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('pro_produto','consult', '/i9im/public/pro_produto/pro_produtoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${pro_produtoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Pro_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_nr_cdfamilia" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_nr_cdfamilia}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_dt_atualizacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<fmt:formatDate value="${item.pro_dt_atualizacao}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_nr_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_tx_situacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_tx_situacao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Gru_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.gru_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ses_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.ses_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sug_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.sug_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_tx_obs" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/pro_produto/pro_produtoUpdateDelete.jsp&op=findbyid&pro_produtoT.pro_nr_id=${item.pro_nr_id}&">
      		<c:out value="${item.pro_tx_obs}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('pro_produto','delete', '/i9im/public/pro_produto/pro_produtoConsult.jsp?pro_produtoT.pro_nr_id=${item.pro_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
