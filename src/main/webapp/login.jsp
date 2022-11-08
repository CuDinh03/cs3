<%@ page import="service.UserService" %>
<%@ page import="dao.LoginDao" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: maccuacu
  Date: 31/10/2022
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = LoginDao.login(username, password);
%>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.css"
            rel="stylesheet"
    />
    <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.js"
    ></script>
</head>
<body>
<div align="center" style="margin-top: 50px">
    <div class="box" style="width: 26rem;" >
        <form method="post" action="/login">
            <!-- Pills navs -->
            <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="#pills-login" role="tab"
                       aria-controls="pills-login" aria-selected="true">Login</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="tab-register" data-mdb-toggle="pill" href="#pills-register" role="tab"
                       aria-controls="pills-register" aria-selected="false">Register</a>
                </li>
            </ul>
            <!-- Pills navs -->

            <!-- Pills content -->
            <div class="tab-content">
                <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <form>
                        <div class="text-center mb-3">
                            <p>Sign in with:</p>
                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-facebook-f">
                                </i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-google"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-twitter"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-github"></i>
                            </button>
                        </div>

                        <p class="text-center">or:</p>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <input type="text" id="loginName" class="form-control" name="username"/>

                            <label class="form-label" for="loginName" style="margin-left: 0px">Email or username</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 114.4px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-4">
                            <input type="password" id="loginPassword" class="form-control" name="password"/>

                            <label class="form-label" for="loginPassword" style="margin-left: 0px">Password</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 64.8px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- 2 column grid layout -->
                        <div class="row mb-4">
                            <div class="col-md-6 d-flex justify-content-center">
                                <!-- Checkbox -->
                                <div class="form-check mb-3 mb-md-0">
                                    <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked/>
                                    <label class="form-check-label" for="loginCheck"> Remember me </label>
                                </div>
                            </div>

                            <div class="col-md-6 d-flex justify-content-center">
                                <!-- Simple link -->
                                <a href="#!">Forgot password?</a>
                            </div>
                        </div>

                        <!-- Submit button -->

                        <button type="submit" onclick="" class="btn btn-primary btn-block mb-4">
                            Sign in</button>

                        <!-- Register buttons -->
                        <div class="text-center">
                            <p>Not a member? <a href="#pills-register">Register</a></p>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                    <form action="/signup" method="post">
                        <div class="text-center mb-3">
                            <p>Sign up with:</p>
                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-facebook-f"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-google"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-twitter"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-github"></i>
                            </button>
                        </div>

                        <p class="text-center">or:</p>

                        <!-- Name input -->
                        <div class="form-outline mb-4">
                            <input type="text" id="registerName" class="form-control" name="nameUser"/>
                            <label class="form-label" for="registerName" style="margin-left: 0px" >Name</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 42.4px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- Username input -->
                        <div class="form-outline mb-4">
                            <input type="text" id="registerUsername" class="form-control" name="users"/>
                            <label class="form-label" for="registerUsername" style="margin-left: 0px">Username</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 66.4px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <input type="email" id="registerEmail" class="form-control" name="email"/>
                            <label class="form-label" for="registerEmail" style="margin-left: 0px">Email</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 40px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-4">
                            <input type="password" id="registerPassword" class="form-control" name="pasw"/>
                            <label class="form-label" for="registerPassword" style="margin-left: 0px">Password</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 64.8px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- Repeat Password input -->
                        <div class="form-outline mb-4">
                            <input type="password" id="registerRepeatPassword" class="form-control" name="confim"/>
                            <label class="form-label" for="registerRepeatPassword" style="margin-left: 0px">Repeat password</label>
                            <div class="form-notch">
                                <div class="form-notch-leading" style="width: 9px;"></div>
                                <div class="form-notch-middle" style="width: 106.4px;"></div>
                                <div class="form-notch-trailing"></div>
                            </div>
                        </div>

                        <!-- Checkbox -->
                        <div class="form-check d-flex justify-content-center mb-4">
                            <input class="form-check-input me-2" type="checkbox" value="" id="registerCheck" checked
                                   aria-describedby="registerCheckHelpText"/>
                            <label class="form-check-label" for="registerCheck">
                                I have read and agree to the terms
                            </label>
                        </div>

                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary btn-block mb-3">Sign up</button>
                    </form>
                </div>
            </div>
            <!-- Pills content -->
        </form>
    </div>
</div>

<script src="js/js.js"></script>

</body>
</html>
