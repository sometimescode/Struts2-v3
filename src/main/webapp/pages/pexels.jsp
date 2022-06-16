<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Pexels</title>

    <style>
        img {
            width: 100%;
            height: 100%;
            background-size: contain; 
        }

        img.portrait {
            width: 800px;
            height: 1200px;
        }

        img.landscape {
            width: 1200px;
            height: 627px;
        }
    </style>
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
            <s:property value="photoId" />
            <s:property value="error" />
            <s:property value="photoResponse" />

            <!-- <s:property value="imgSrc" /> -->


            <img src="${photoResponse.src.original}" alt="${photoResponse.alt}" />

            <!-- <img src="${imgSrc}" /> -->

        </div>
        <s:form action="Pexels" method="togglePhotoSource">
            <s:radio name="orientation" list="orientationOptions" label="Orientation"/>
            <s:submit/>
          </s:form>
    </main>
  </body>
</html>