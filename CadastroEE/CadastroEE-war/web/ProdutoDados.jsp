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
    <title>Cadastro de Produto</title>
</head>
<body>
    <h1>Cadastro de Produto</h1>
    <form action="ServletProdutoFC" method="post">
        <input type="hidden" name="acao" value="${not empty produto ? 'alterar' : 'incluir'}">
        
        <c:if test="${not empty produto}">
            <input type="hidden" name="id" value="${produto.idProduto}">
        </c:if>
        
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${not empty produto ? produto.nome : ''}">
        
        <label for="quantidade">Quantidade:</label>
        <input type="text" id="quantidade" name="quantidade" value="${not empty produto ? produto.quantidade : ''}">
        
        <label for="preco">Preço:</label>
        <input type="text" id="preco" name="preco" value="${not empty produto ? produto.precoVenda : ''}">
        <br>
        
        <input type="submit" value="${not empty produto ? 'Alterar' : 'Incluir'}">
    </form>
</body>
</html>
