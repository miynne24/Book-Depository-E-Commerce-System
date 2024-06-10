 <!DOCTYPE html>
<html>
<head>
  <title>Homepage</title>
 <style type="text/css">
body {
    margin: 0;
    text-align: center;
      background:#150a33;
      display: flex;
      align-items: flex-end;
      justify-content: center;
      height: 100vh;
}
.uitm{
   position: left-top;
   
}
.sample-header {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
 background: #ffffff;
}
.sample-header::before {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-image: url('image/uitm2.jpg');
   background-repeat: no-repeat;
      background-size: cover;
      background-position: left-top;
  opacity: 0.5;
}
.sample-header-section {
  position: relative;
  padding: 15% 0 10%;
  max-width: 640px;
  margin-left: auto;
  margin-right: auto;
  color: white;
  text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5);
  font-family: "Montserrat", sans-serif;
}

.sample-section-wrap {
  position: bottom- left;
  background-color: none;
}
.sample-section {
  position: relative;
  max-width: 640px;
  margin-left: auto;
  margin-right: auto;
  padding: 40px;
}

    .h1 {
      font-weight:500;
      font-family:montserrat;
      color: #6b46cf;
    }
    
    .button {
      font-family: Bahnschrift;
      display: inline-block;
      padding: 10px 20px;
      font-size: 16px;
      border-radius: 10px;
      background-color: #fff;
      color: #000;
      text-decoration: none;
      margin: 10px;
      cursor: pointer;
    }
    
    .button:hover {
      background-color: #0056b3;
    }
    </style>
  <link rel="stylesheet" href="css/hompage.css">
</head>
<body>
   <div class="sample-header">
      <div class="sample-header-section">
        <img alt="uitm" src="image/uitm1.png">
        <h1>Welcome to the UiTM Preloved Book Depository</h1>
        
      </div>
  </div>

  <div class="sample-section-wrap">
  <div class="sample-section">
   <a href="studLogin.jsp" class="button">Student</a>
    <a href="adminLogin.jsp" class="button">Admin</a>
  </div>
  </div>
</body>
</html>