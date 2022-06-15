<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>News</title>
    <style>
      #verticalList {
        padding: 0px 50px;
        list-style-type: none;
      }

      #verticalList li {
        background-color: #eee;
        color: black;
        display: block;
        float: left;
        width: 100%;
        margin: 0px 0px 10px 0px;
        padding: 10px 0px;
      }

      #verticalList li div {
        margin-top: 5px;
        padding: 0 15px;
      }

      #verticalList li.errorPink {
        background-color: lightpink;
      }

      .dateSpan {
        padding: 0 10 0 15;
        border-radius: 0 10px 10px 0;
        background-color: lightgrey;
      }

      .titleSpan {
        font-weight: 600;
      }
      
    </style>    
  </head>
  <body>
    <s:include value="menu.jsp" />

    <main>
      <header class="center">
        <h2>News Feed</h2>
      </header>

      <!-- Total Results: <s:property value="newsResponse.totalresults"/>
      <s:property value="newsResponse.status"/>
      <s:property value="urlQuery"/> -->

      <div>
        <s:form action="News">
          <s:textfield name="q" label="Search"/>
          <!-- <s:radio name="language" list="languages" label="Language"/> -->
          <s:radio name="language" list="languages" listKey="languageAbbr" listValue="languageName" label="Language"/>
          <s:radio name="sortBy" list="sortByOptions" label="Sort by"/>
          <s:submit/>
        </s:form>
        <ul id="verticalList">
          <s:if test="error != null && q.isEmpty() == false">
            <li class="center errorPink"><s:property value="error"/></li>
          </s:if>
          <s:if test="error != null && q.isEmpty() == true">
            <li class="center">Enter a search term.</li>
          </s:if>
          <s:if test="error == null && newsResponse.articles.isEmpty() == true">
            <li class="center">No articles found.</li>
          </s:if>
          <s:iterator value="newsResponse.articles">  
          <li>
            <span class="dateSpan"><s:property value="publishedAt"/></span>
            <div>
              <span class="titleSpan"><s:property value="title"/></span> by <s:property value="author"/>
              <hr>
              <p><s:property value="description"/></p>
              <hr>
              Read more: <a href="${url}"><s:property value="url"/></a>
            </div>
          </li>
          </s:iterator>
        </ul> 
      </div>
    </main>
  </body>
</html>