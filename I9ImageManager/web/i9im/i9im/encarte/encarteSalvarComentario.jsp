<jsp:useBean id="encarteSalvar" class="br.com.i9.imagemanager.jb.EncarteSalvarComentarioJB" scope="request"/>
<jsp:setProperty name="encarteSalvar" property="*"/>
<jsp:setProperty name="encarteSalvar" property="page" value="${pageContext}"/>
${encarteSalvar.execute}
