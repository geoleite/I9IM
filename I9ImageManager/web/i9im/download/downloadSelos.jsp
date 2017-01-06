<jsp:useBean id="download" class="br.com.i9.imagemanager.jb.DownloadSelosJB" scope="request"/>
<jsp:setProperty name="download" property="*"/>
<jsp:setProperty name="download" property="page" value="${pageContext}"/>
${download.execute}
