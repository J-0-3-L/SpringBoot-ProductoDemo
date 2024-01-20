<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value='/' />">Inicio</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/tienda' />">Dashboard</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <h1>${categoria.name}</h1>
                <br>
                <div class="card border rounded shadow">
                    <div class="card-body">
                        <form action="<c:url value='/categorias/${categoria.id}' />" method="post">
                            <div class="form-group">
                                <label for="producto">Agregar producto:</label>
                                <select name="producto_id" class="form-control" required>
                                    <c:forEach items="${productos}" var="producto">
                                        <option value="${producto.id}">${producto.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">ADD</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container mt-5">
        <div class="row justify-content-center">
          <div class="col-sm-4">
            <h2>Productos</h2>
            <div class="card mt-5">
              <div class="card-body">
                <c:forEach items="${categoria.productos}" var="producto">
                    <p>${producto.name}</p>     
                </c:forEach>
            </div>
          </div>
        </div>
    </div>
</body>
</html>