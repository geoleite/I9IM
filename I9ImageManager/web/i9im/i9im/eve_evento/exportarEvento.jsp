<jsp:useBean id="exportar" class="br.com.i9.imagemanager.jb.ExportarEventoJB" scope="request"/>
<jsp:setProperty name="exportar" property="*"/>
<jsp:setProperty name="exportar" property="page" value="${pageContext}"/>
${exportar.execute}
{"resultado":"${exportar.msg}"}
