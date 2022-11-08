<%@ page import="dao.CRUD_Product" %>
<%@ page import="model.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.Connect_MySql" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: maccuacu
  Date: 02/11/2022
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        CRUD_Product pDao = new CRUD_Product(Connect_MySql.getConnect());
        cartProduct = pDao.getCartProducts(cart_list);
        double total = pDao.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
        request.setAttribute("cart_list", cart_list);
    }
%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop </title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/cart.css" rel="stylesheet" />
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

<section class="h-100 h-custom" style="background-color: #eee;">
    <div class="container h-100 py-5">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card shopping-cart" style="border-radius: 15px;">
                    <div class="card-body text-black">

                        <div class="row">
                            <div class="col-lg-6 px-5 py-4">

                                <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Your products</h3>

                                <tbody>
                                <%
                                    if (cart_list != null) {
                                        for (Cart c : cartProduct) {

                                %>

                                <div class="d-flex align-items-center mb-5">
                                    <div class="flex-shrink-0">
                                        <img src="<%= c.getImg()%>"
                                             class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                                    </div>
                                    <div class="flex-grow-1 ms-3">
                                        <a href="#!" class="float-end text-black"><i class="fas fa-times"></i></a>
                                        <h5 class="text-primary"><%= c.getNameProduct()%></h5>
                                        <div class="d-flex align-items-center">
                                            <p class="fw-bold mb-0 me-5 pe-3"><%= dcf.format(c.getPrice())%></p>
                                            <div class="def-number-input number-input safari_only">
                                                <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                        class="minus"></button>
                                                <input class="quantity fw-bold text-black" min="0" name="quantity" value="1"
                                                       type="number">
                                                <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                        class="plus"></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%
                                        }}%>
                                </tbody>

                                <hr class="mb-4" style="height: 2px; background-color: #1266f1; opacity: 1;">

                                <div class="d-flex justify-content-between px-x">
                                    <p class="fw-bold"></p>
                                </div>


                                <div class="d-flex justify-content-between p-2 mb-2" style="background-color: #e1f5fe;">
                                    <h5 class="fw-bold mb-0">Total:</h5>
                                    <h5 class="fw-bold mb-0">${(total>0)?dcf.format(total):0} $</h5>
                                </div>

                            </div>


                            <div class="col-lg-6 px-5 py-4">

                                <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Payment</h3>

                                <form class="mb-5">

                                    <div class="form-outline mb-5">
                                        <input type="text" id="typeText" class="form-control form-control-lg" siez="17"
                                                minlength="19" maxlength="19" />
                                        <label class="form-label" for="typeText">Card Number</label>
                                    </div>

                                    <div class="form-outline mb-5">
                                        <input type="text" id="typeName" class="form-control form-control-lg" siez="17"
                                                />
                                        <label class="form-label" for="typeName">Name on card</label>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-5">
                                            <div class="form-outline">
                                                <input type="text" id="typeExp" class="form-control form-control-lg"
                                                       size="7" id="exp" minlength="7" maxlength="7" />
                                                <label class="form-label" for="typeExp">Expiration</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-5">
                                            <div class="form-outline">
                                                <input type="password" id="typeText" class="form-control form-control-lg"
                                                        size="1" minlength="3" maxlength="3" />
                                                <label class="form-label" for="typeText">Cvv</label>
                                            </div>
                                        </div>
                                    </div>


                                    <button type="button" class="btn btn-primary btn-block btn-lg">Buy now</button>

                                    <h5 class="fw-bold mb-5" style="position: absolute; bottom: 0;">
                                        <a href="index.jsp"><i class="fas fa-angle-left me-2"></i>Back to shopping</a>
                                    </h5>

                                </form>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
