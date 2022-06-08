<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Login</title>
    <style>
      #formContainer {
        background-color: #eee;
        width: 50%;
        margin: auto;
        text-align: center;
        padding: 10px 20px;
      }

      input {
        color: #5f5f5f;
        box-sizing: border-box;
        width: 290px;
        box-shadow: 1px 2px 4px 0 rgb(0 0 0 / 8%);
        padding: 10px;
        border: 1px solid #dbdbdb;
        margin: 5px 0px;
      }

      input[type=submit] {
        background-color: #6caee0;
        color: #ffffff;
        width: 100%;
        margin-top: 25px;
        font-weight: bold;
      }
    </style>
  </head>
  <body>
    <s:include value="Menu.jsp" />

    <main>
      <div id="formContainer">
        <h2>Member Login</h2>

        <s:form action="CheckUserCredentials">
          <s:textfield key="username" label="Username"/>
          <s:password key="password" label="Password"/>
          <s:submit key="submit"/>  
        </s:form>
        <h4><s:property value="validationString"/></h4>
      </div>
    </main>
  </body>
</html>