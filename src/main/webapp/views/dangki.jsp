<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/css/login.css">
    <title>Login</title>
</head>
<body>
    <div class="d-flex justify-content-center align-items-center min-vh-100" style="background-image: url('../views/images/hinh-sieu-xe-32.jpg'); background-size: cover;">
        <div class="row border rounded-5 p-3 bg-white shadow box-area">
            <!-- Left Box -->
            <div class="col-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background-image: url('../views/images/hinh-sieu-xe-32.jpg'); background-size: cover;">
                <div class="featured-image mb-3"></div>
            </div>
            <!-- Right Box -->
            <div class="col-md-6 right-box p-5">
                <div class="row align-items-center">
                    <div class="header-text ">
                        <h2 class="text-center mb-4">Register</h2>
                        <p>We are happy to have you back.</p>
                    </div>
                    <form action="/signup" method="POST">
                    <div class="input-group mb-3">
                            <input type="text" class="form-control form-control-lg bg-light fs-6" placeholder="Name" name="name">
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control form-control-lg bg-light fs-6" placeholder="Email address" name="email">
                        </div>
                        <div class="input-group mb-3">
                                <input type="password" name="password" placeholder="Password" class="form-control bg-light fs-6 border-end-0">
                                <span class="input-group-text bg-white  border-start-0"><i class="fa-solid fa-eye"></i></span>
                            </div>
                            <div class="input-group mb-3">
                                <input type="password" name="fwpass" placeholder="Forward-Password" class="form-control bg-light fs-6 border-end-0">
                                <span class="input-group-text bg-white border-start-0"><i class="fa-solid fa-eye"></i></span>
                            </div>
                       <div class="form-group mb-3">
                                <label for="gender">Giới tính</label>
                                <div>
                                    <div class="form-check form-check-inline">
                                        <input type="radio" name="gender" id="male" value="male" class="form-check-input">
                                        <label for="male" class="form-check-label">Nam</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input type="radio" name="gender" id="female" value="female" class="form-check-input">
                                        <label for="female" class="form-check-label">Nữ</label>
                                    </div>
                                </div>
                            </div>
                            <button class="register-btn form-control mb-3 btn btn-primary">Register</button>
                            <p class="text-center">Already A Member <a href="/views/login.jsp" class="link"><b>Log in</b></a></p>
                        
                    </form>
                                      
                </div>
            </div> 
        </div>
    </div>	
      <script src="https://kit.fontawesome.com/03099bb746.js" crossorigin="anonymous"></script>
</body>
</html>
