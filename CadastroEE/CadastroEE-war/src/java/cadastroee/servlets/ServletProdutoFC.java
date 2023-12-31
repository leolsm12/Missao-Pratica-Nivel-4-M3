/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.ejb.EJB;
import cadastroee.controller.ProdutosFacadeLocal;
import cadastroee.model.Produtos;
import java.util.List;
/**
 *
 * @author leosc
 */
@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {
    @EJB
    ProdutosFacadeLocal facade;   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = null;

        switch (acao) {
            case "listar":
                List<Produtos> produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
                break;
            case "formIncluir":
                destino = "ProdutoDados.jsp";
                break;
            case "formAlterar":
                int idAlterar = Integer.parseInt(request.getParameter("id"));
                Produtos produtoAlterar = facade.find(idAlterar);
                request.setAttribute("produto", produtoAlterar);            
                destino = "ProdutoDados.jsp";
                break;
            case "excluir":
                int idExcluir = Integer.parseInt(request.getParameter("id"));
                Produtos produtoExcluir = facade.find(idExcluir);
                facade.remove(produtoExcluir);
                List<Produtos> produtosExcluidos = facade.findAll();
                request.setAttribute("produtos", produtosExcluidos);
                destino = "ProdutoLista.jsp";
                break;
            default:
                break;
        }
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response); 
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        List<Produtos> produtos = null;

        switch (acao) {
            case "incluir":
                String nome = request.getParameter("nome");
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                float preco = Float.parseFloat(request.getParameter("preco"));
                produtos = facade.findAll();
                int ultimoId = 0;              
                Produtos ultimoProduto = produtos.get(produtos.size() - 1);
                ultimoId = ultimoProduto.getIdProduto();                
                int id = ultimoId + 1;
                
                Produtos novoProduto = new Produtos();
                novoProduto.setNome(nome);
                novoProduto.setQuantidade(quantidade);
                novoProduto.setPrecoVenda(preco);
                novoProduto.setIdProduto(id);

                facade.create(novoProduto);

                produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
                
                break;
            
            case "alterar":
                int idAlterar = Integer.parseInt(request.getParameter("id"));
                Produtos produtoExistente = facade.find(idAlterar);

                if (produtoExistente != null) {
                    String novoNome = request.getParameter("nome");
                    String novaQuantidadeStr = request.getParameter("quantidade");
                    String novoPrecoStr = request.getParameter("preco");

                    int novaQuantidade = 
                            (novaQuantidadeStr != null && !novaQuantidadeStr.isEmpty())
                            ? Integer.parseInt(novaQuantidadeStr) : produtoExistente.getQuantidade();
                    float novoPreco = 
                            (novoPrecoStr != null && !novoPrecoStr.isEmpty()) 
                            ? Float.parseFloat(novoPrecoStr) : produtoExistente.getPrecoVenda();

                    produtoExistente.setNome(novoNome);
                    produtoExistente.setQuantidade(novaQuantidade);
                    produtoExistente.setPrecoVenda(novoPreco);

                    facade.edit(produtoExistente);
                    produtos = facade.findAll();
                    request.setAttribute("produtos", produtos);
                } else {
                    produtos = facade.findAll();
                    request.setAttribute("produtos", produtos);
                }
                break; 
        }
        RequestDispatcher rd = request.getRequestDispatcher("ProdutoLista.jsp");
        rd.forward(request, response);
}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
