<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/css/signup.css">
    <title>Register</title>
</head>
<body>
    <section class="main">
        <div class="container-fluid vh-100" style="background-image: url('../views/images/hinh-sieu-xe-32.jpg'); background-size: cover;">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-lg-7 col-md-12 d-flex align-items-center">
                    <div class="text text-center">
                        <h1 class="text-danger">Create Your Best Experience!</h1>
                        <h2 class="text-dark">Welcome To Baby</h2>
                    </div>
                </div>
                <div class="col-lg-5 col-md-10 col-sm-12">
                    <div class="form-box">
                        <form action="">
                            <h2 class="text-center mb-4">Register</h2>
                            <input type="text" name="name" placeholder="Name" class="form-control mb-3">
                            <input type="email" name="email" placeholder="Email" class="form-control mb-3">
                            <div class="input-group mb-3">
                                <input type="password" name="password" placeholder="Password" class="form-control border-end-0">
                                <span class="input-group-text bg-white border-start-0"><i class="fa-solid fa-eye"></i></span>
                            </div>
                            <div class="input-group mb-3">
                                <input type="password" name="fwpass" placeholder="Forward-Password" class="form-control border-end-0">
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
                            <button class="register-btn form-control mb-3">Register</button>
                            <p class="text-center">Already A Member <a href="/views/login.jsp" class="link"><b>Log in</b></a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="https://kit.fontawesome.com/03099bb746.js" crossorigin="anonymous"></script>
</body>
</html>
