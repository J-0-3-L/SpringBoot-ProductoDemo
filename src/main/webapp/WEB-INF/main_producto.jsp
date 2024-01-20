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
                <h1>${producto.name}</h1>
                <br>
                <div class="card border rounded shadow">
                    <div class="card-body">
                        <form action="<c:url value='/productos/${producto.id}' />" method="post">
                            <div class="form-group">
                                <label for="categoria">Agregar categoria:</label>
                                <select name="categoria_id" class="form-control" required>
                                    <c:forEach items="${categorias}" var="categoria">
                                        <option value="${categoria.id}">${categoria.name}</option>
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
            <h2>Categorias</h2>
            <div class="card mt-5">
              <div class="card-body">
                <c:forEach items="${producto.categorias}" var="categoria">
                    <p>${categoria.name}</p>   
                </c:forEach>
            </div>
          </div>
        </div>
    </div>
</body>
</html>