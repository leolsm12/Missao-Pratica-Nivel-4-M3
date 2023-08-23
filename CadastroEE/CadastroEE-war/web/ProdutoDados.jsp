<%-- 
    Document   : ProdutoDados
    Created on : 21 de ago. de 2023, 22:58:54
    Author     : leosc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">   
    <title>Cadastro de Produto</title>
</head>
<body class="container">
    <h1>${empty produto ? 'Cadastro de Produto' : 'Dados do produto'}</h1>
    <form class="form" action="ServletProdutoFC" method="post">
        <input type="hidden" name="acao" value="${not empty produto ? 'alterar' : 'incluir'}">
        
        <c:if test="${not empty produto}">
            <input type="hidden" name="id" value="${produto.idProduto}">
        </c:if>
        <div class="mb-3">
            <label class="form-label" for="nome">Nome:</label>
            <input class="form-control" type="text" id="nome" name="nome" value="${not empty produto ? produto.nome : ''}">
        </div>
        <div class="mb-3">    
            <label class="form-label" for="quantidade">Quantidade:</label>
            <input class="form-control" type="text" id="quantidade" name="quantidade" value="${not empty produto ? produto.quantidade : ''}">
        </div> 
        <div class="mb-3">    
            <label class="form-label" for="preco">Preço:</label>
            <input class="form-control" type="text" id="preco" name="preco" value="${not empty produto ? produto.precoVenda : ''}">
        </div>
            <br>
        
        <input class="btn  btn-primary" type="submit" value="${not empty produto ? 'Alterar' : 'Incluir'}">
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
