<%@ page import="service.ProductService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2>Danh sách sản phẩm </h2>
    <a href="index.jsp" type="button">Home</a>
    <a href="addProduct.jsp" type="button">Add</a>
    <form action="/edit-product" method="post">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Calo</th>
                <th>Quantity</th>
                <th>IMG</th>

            </tr>
            <tbody>
            <tr>
                <td><input type="text" value="${pr.idProduct}"name="id1" readonly/></td>
                <td>
                    <input type="text" value="${pr.nameProduct}" name="name1" />
                </td>
                <td>
                    <input type="text" value="${pr.price}" name="price1" />
                </td>
                <td>
                    <input type="text" value="${pr.calo}" name="calo1" />
                </td>
                <td>
                    <input type="text" value="${pr.quantity}" name="quantity1" />
                </td>
                <td>
                    <input type="text" value="${pr.img}" name="img1"/>
                </td>

            </tr>

            </tbody>
            <tr>
                <th>Choice</th>
            </tr>
            <tr>
                <td>
                    <button type="submit" class="btn btn-success">Edit</button>
                </td>
                <td>
                    <a type="button" class="btn btn-warning" href="/adminView.jsp">Cancel</a>
                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>

