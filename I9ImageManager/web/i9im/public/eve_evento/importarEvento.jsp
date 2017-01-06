<jsp:useBean id="importar" class="br.com.i9.imagemanager.jb.ImportarEventoJB" scope="request"/>
<jsp:setProperty name="importar" property="*"/>
<jsp:setProperty name="importar" property="page" value="${pageContext}"/>
${importar.execute}
{"resultado":"${importar.msg}"}
