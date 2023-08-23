<%-- 
    Document   : ProdutoLista
    Created on : 21 de ago. de 2023, 17:15:32
    Author     : leosc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
            <title>Lista de Produtos</title>
        </head>
        <body class="container">
            <h1>Listagem de Produtos</h1>
    <a class="btn btn-primary  m-2" href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>
    <table class="table table-striped" border="1">
        <tr class="table-dark">
            <th>#</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th>Opções</th>
        </tr>
        <!-- Aqui virá a lista de produtos -->
        <%-- Loop para exibir a lista de produtos --%>
        <c:forEach items="${produtos}" var="produto">
    <tr>
        <td>${produto.idProduto}</td>
        <td>${produto.nome}</td>
        <td>${produto.quantidade}</td>
        <td>${produto.precoVenda}</td>
        <td>
            <a class="btn btn-primary  btn-sm" href="ServletProdutoFC?acao=formAlterar&id=${produto.idProduto}">Alterar</a>
            <a class="btn btn-danger  btn-sm" href="ServletProdutoFC?acao=excluir&id=${produto.idProduto}"">Excluir</a>
        </td>
    </tr>
    </c:forEach>
    
   </table>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>

