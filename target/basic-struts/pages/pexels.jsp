<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Pexels</title>
  </head>
  <body>
    <s:include value="menu.jsp" />

    <main>
      <header class="center">
        <h2>Pexels</h2>
      </header>

      <!-- Total Results: <s:property value="newsResponse.totalresults"/>
      <s:property value="newsResponse.status"/>
      <s:property value="urlQuery"/> -->
        <div>
            <s:property value="photoResponse" />
        </div>
    </main>
  </body>
</html>