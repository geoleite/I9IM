<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="sel_seloJB" class="br.com.i9.imagemanager.jb.Sel_seloConsultJB" scope="request"/>                                         
<jsp:setProperty name="sel_seloJB" property="*"/>                                         
<jsp:setProperty name="sel_seloJB" property="page" value="${pageContext}"/>                                         
${sel_seloJB.execute}                                         
                                                                                

<form name="sel_selo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/sel_selo/sel_seloConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${sel_seloJB.tipoMsg}">${sel_seloJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('sel_selo','', '/i9im/public/sel_selo/sel_seloInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('sel_selo','consult', '/i9im/public/sel_selo/sel_seloConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${sel_seloJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Sel_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.sel_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cls_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.cls_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tid_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.tid_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.sel_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.sel_tx_descricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_dt_cadastro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<fmt:formatDate value="${item.sel_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_tx_situacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.sel_tx_situacao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_bt_arquivo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<img border="0" src="/easyportal/i9im/sel_selo/sel_seloUpdateDelete.jsp?op=downloadImage&sel_seloT.sel_nr_id=${item.sel_nr_id}&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_dt_validadeinicio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<fmt:formatDate value="${item.sel_dt_validadeinicio}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_dt_validadefim" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<fmt:formatDate value="${item.sel_dt_validadefim}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sel_tx_promocional" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/sel_selo/sel_seloUpdateDelete.jsp&op=findbyid&sel_seloT.sel_nr_id=${item.sel_nr_id}&">
      		<c:out value="${item.sel_tx_promocional}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('sel_selo','delete', '/i9im/public/sel_selo/sel_seloConsult.jsp?sel_seloT.sel_nr_id=${item.sel_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
