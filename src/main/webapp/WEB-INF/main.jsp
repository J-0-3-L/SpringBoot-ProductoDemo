<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value='/' />">Inicio</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/productos/new' />">Agregar Producto</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/categorias/new' />">Agregar Categoria</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-8">
                <h1>Productos</h1>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
				                <th>Description</th>
				                <th>Price</th>
				                <th>Category Count</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${productos}" var="producto">
                                <tr>
                                    <td>${producto.name}</td>
					                <td>${producto.description}</td>
					                <td>${producto.price}</td>
					                <td>${producto.categorias.size()} categorias</td>
                                    <td><a href="<c:url value='/productos/${producto.id}' />">Ver</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-8">
                <h1>Categorias</h1>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Category Name</th>
				                <th>Product Count</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${categorias}" var="categoria">
                                <tr>
                                    <td>${categoria.name}</td>
					                <td>${categoria.productos.size()} productos</td>
                                    <td><a href="<c:url value='/categorias/${categoria.id}' />">Ver</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>