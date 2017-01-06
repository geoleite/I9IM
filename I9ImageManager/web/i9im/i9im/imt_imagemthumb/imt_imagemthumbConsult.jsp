<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="imt_imagemthumbJB" class="br.com.i9.imagemanager.jb.Imt_imagemthumbConsultJB" scope="request"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="*"/>                                         
<jsp:setProperty name="imt_imagemthumbJB" property="page" value="${pageContext}"/>                                         
${imt_imagemthumbJB.execute}                                         
                                                                                

<form name="imt_imagemthumb" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${imt_imagemthumbJB.tipoMsg}">${imt_imagemthumbJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('imt_imagemthumb','', '/i9im/public/imt_imagemthumb/imt_imagemthumbInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('imt_imagemthumb','consult', '/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${imt_imagemthumbJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cd_arquivo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp&op=findbyid&imt_imagemthumbT.cd_arquivo=${item.cd_arquivo}&imt_imagemthumbT.cd_produto=${item.cd_produto}&imt_imagemthumbT.imt_nr_id=${item.imt_nr_id}&">
      		<c:out value="${item.cd_arquivo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cd_produto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp&op=findbyid&imt_imagemthumbT.cd_arquivo=${item.cd_arquivo}&imt_imagemthumbT.cd_produto=${item.cd_produto}&imt_imagemthumbT.imt_nr_id=${item.imt_nr_id}&">
      		<c:out value="${item.cd_produto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Imt_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp&op=findbyid&imt_imagemthumbT.cd_arquivo=${item.cd_arquivo}&imt_imagemthumbT.cd_produto=${item.cd_produto}&imt_imagemthumbT.imt_nr_id=${item.imt_nr_id}&">
      		<c:out value="${item.imt_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Imt_bt_thumb" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9im/public/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp&op=findbyid&imt_imagemthumbT.cd_arquivo=${item.cd_arquivo}&imt_imagemthumbT.cd_produto=${item.cd_produto}&imt_imagemthumbT.imt_nr_id=${item.imt_nr_id}&">
      		<img border="0" src="/easyportal/i9im/imt_imagemthumb/imt_imagemthumbUpdateDelete.jsp?op=downloadImage&imt_imagemthumbT.cd_arquivo=${item.cd_arquivo}&imt_imagemthumbT.cd_produto=${item.cd_produto}&imt_imagemthumbT.imt_nr_id=${item.imt_nr_id}&"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('imt_imagemthumb','delete', '/i9im/public/imt_imagemthumb/imt_imagemthumbConsult.jsp?imt_imagemthumbT.cd_arquivo=${item.cd_arquivo}&imt_imagemthumbT.cd_produto=${item.cd_produto}&imt_imagemthumbT.imt_nr_id=${item.imt_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
