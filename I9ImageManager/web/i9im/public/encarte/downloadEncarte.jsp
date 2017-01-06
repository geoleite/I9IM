<jsp:useBean id="downloadEncarte" class="br.com.i9.imagemanager.jb.DownloadEncarteJB" scope="request"/>
<jsp:setProperty name="downloadEncarte" property="*"/>
<jsp:setProperty name="downloadEncarte" property="page" value="${pageContext}"/>
${downloadEncarte.execute}
