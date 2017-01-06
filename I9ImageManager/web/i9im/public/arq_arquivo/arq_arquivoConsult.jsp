<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="arq_arquivoJB" class="br.com.i9.imagemanager.jb.Arq_arquivoConsultJB" scope="request"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="*"/>                                         
<jsp:setProperty name="arq_arquivoJB" property="page" value="${pageContext}"/>                                         
${arq_arquivoJB.execute}                                         
                                                                                

<form name="arq_arquivo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/arq_arquivo/arq_arquivoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${arq_arquivoJB.tipoMsg}">${arq_arquivoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('arq_arquivo','', '/i9im/public/arq_arquivo/arq_arquivoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('arq_arquivo','consult', '/i9im/public/arq_arquivo/arq_arquivoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${arq_arquivoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cd_produto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.cd_produto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.arq_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cd_tipoimagem" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.cd_tipoimagem}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cd_tipodocumento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.cd_tipodocumento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.arq_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.arq_tx_descricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_dt_cadastro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<fmt:formatDate value="${item.arq_dt_cadastro}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_tx_situacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.arq_tx_situacao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_bt_arquivo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<img border="0" src="/easyportal/i9im/arq_arquivo/arq_arquivoUpdateDelete.jsp?op=downloadImage&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_dt_validadeinicio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<fmt:formatDate value="${item.arq_dt_validadeinicio}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_dt_validadefim" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<fmt:formatDate value="${item.arq_dt_validadefim}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arq_tx_promocional" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/arq_arquivo/arq_arquivoUpdateDelete.jsp&op=findbyid&arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&">
      		<c:out value="${item.arq_tx_promocional}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('arq_arquivo','delete', '/i9im/public/arq_arquivo/arq_arquivoConsult.jsp?arq_arquivoT.cd_produto=${item.cd_produto}&arq_arquivoT.arq_nr_id=${item.arq_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
