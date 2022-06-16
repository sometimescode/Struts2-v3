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
    <s:include value="menu.jsp" />

    <main>
      <header class="center">
        <h2>Pexels2</h2>
      </header>
        <div>
            <s:form action="Pexels2Search">
                <s:textfield name="searchQuery" label="Search"/>
                <s:submit/>
            </s:form>
        </div>
        <div>
            <s:iterator value="photosSearchResponse.photos">  
                <s:property value="src.original"/>
            </s:iterator>
        </div>
            
        <!-- <s:iterator value="photosSearchResponse.photos">  
            <img src="${src.original}"/>
        </s:iterator> -->

        <div class="container">
            <div class="row" data-masonry='{"percentPosition": true }'>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/15286/pexels-photo.jpg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/3408744/pexels-photo-3408744.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/624015/pexels-photo-624015.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/572897/pexels-photo-572897.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/3244513/pexels-photo-3244513.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/3225517/pexels-photo-3225517.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/1761279/pexels-photo-1761279.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/1770809/pexels-photo-1770809.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/2440061/pexels-photo-2440061.jpeg" class="img-fluid" />
                </div>
                <div class="col-3">
                    <img src="https://images.pexels.com/photos/2627945/pexels-photo-2627945.jpeg" class="img-fluid" />
                </div>
            </div>
        </div>
    </main>

    <div class="row">
        <div class="col-sm-6">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Special title treatment</h5>
              <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div>
        </div>
        <div class="col-sm-6">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Special title treatment</h5>
              <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div>
        </div>
      </div>


    <script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>