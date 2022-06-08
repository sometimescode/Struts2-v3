<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Register</title>
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
    <s:include value="menu.jsp" />

    <main>
      <div id="formContainer">
        <h2>Account Registration</h2>
        
        <s:form action="AddUserToDB">
          <s:textfield name="accountBean.username" label="Username" />
          <s:textfield name="accountBean.password" label="Password" />
          <s:textfield name="accountBean.firstName" label="First Name" />
          <s:textfield name="accountBean.lastName" label="Last Name" />
          <s:textfield name="accountBean.email" label="Email Address" />
          <s:submit />
        </s:form>	
      </div>
    </main>
  </body>
</html>