<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    

    <title>Pexels2</title>
  </head>
  <body>
    <main>
      <header class="center">
        <h2>Photos Search</h2>
      </header>
        <div>
            <s:form action="Pexels2Search" theme="simple">
                <s:textfield name="searchQuery" label="Search"/>
                <s:submit/>
            </s:form>
        </div>
        <!-- <div>
            <s:iterator value="photosSearchResponse.photos">  
                <s:property value="src.original"/>
            </s:iterator>
        </div> -->
        
        <div class="container">
          <div class="row">
            <div class="col">
              Total Results: <s:property value="photosSearchResponse.total_results"/>
            </div>
          </div>
          <div class="row">
            <div class="col-4">
              <s:if test="photosSearchResponse.prev_page != null">
                <s:url var="prevPage" action="Pexels2FetchPage" namespace="/">
                  <s:param name="searchQuery" value="%{photosSearchResponse.prev_page}"/>
                </s:url>
                <s:property value="%{prevPage}"/> [divider]
                <s:property value="%{photosSearchResponse.prev_page}"/>
                <a href="${prevPage}">Previous</a>
              </s:if>
            </div>
            <div class="col-4">
              <s:property value="photosSearchResponse.page"/>
            </div>
            <div class="col-4">
              <s:if test="photosSearchResponse.next_page != null">
                <s:url var="nextPage" action="Pexels2FetchPage" namespace="/">
                  <s:param name="searchQuery" value="%{photosSearchResponse.next_page}" />
                </s:url>
                <s:property value="%{nextPage}"/> [divider]
                <s:property value="%{photosSearchResponse.next_page}"/>
                <a href="${nextPage}">Next</a>
              </s:if>
            </div>
          </div>          
        </div>

        <div class="container">
          <div class="row g-2" data-masonry='{"percentPosition": true }'>
              <s:iterator value="photosSearchResponse.photos">  
                <div class="col-xs-12 col-sm-6 col-md-3">
                  <s:url action="Pexels" var="photoDetailsLink"> 
                    <s:param name="photoId" value="%{id}"/>
                  </s:url> 
                  <a href="${photoDetailsLink}"><img src="${src.original}" class="img-fluid" /></a>
              </div>
            </s:iterator> 
          </div>
        </div>

        <!-- <div class="container">
            <div class="row" data-masonry='{"percentPosition": true }'>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <s:url action="Pexels" var="photoDetailsLink"> 
                      <s:param name="photoId" value="15286"/>
                    </s:url> 
                    <a href="${photoDetailsLink}"><img src="https://images.pexels.com/photos/15286/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" /></a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/3408744/pexels-photo-3408744.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/624015/pexels-photo-624015.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/572897/pexels-photo-572897.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/3244513/pexels-photo-3244513.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/3225517/pexels-photo-3225517.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/1761279/pexels-photo-1761279.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/1770809/pexels-photo-1770809.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/2440061/pexels-photo-2440061.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <img src="https://images.pexels.com/photos/2627945/pexels-photo-2627945.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280" class="img-fluid" />
                </div>
            </div>
        </div> -->
    </main>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
  </body>
</html>