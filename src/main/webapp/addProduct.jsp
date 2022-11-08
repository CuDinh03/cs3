<%--
  Created by IntelliJ IDEA.
  User: maccuacu
  Date: 07/11/2022
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
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
    <form action="/addProduct" method="post">
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Calo</th>
            <th>Quantity</th>
            <th>IMG</th>

        </tr>
        <tr>
            <td>
                <input type="text" placeholder="" name="name" />
            </td>
            <td>
            <input type="text" placeholder="" name="price" />
        </td>
            <td>
            <input type="text" placeholder="" name="calo" />
        </td>
            <td>
            <input type="text" placeholder="" name="quantity" />
        </td>
            <td>
                <input type="text" placeholder="" name="img"/>
            </td>

        </tr>
        <tr>
            <th>Choice</th>
        </tr>
        <tr>
            <td>
                <button type="submit" class="btn btn-success">Add</button>
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
