/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week3.controller;

import edu.wctc.dj.week3.model.Product;
import edu.wctc.dj.week3.model.ProductService;
import edu.wctc.dj.week3.model.StaticPage;
import edu.wctc.dj.week3.model.StaticPageService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryan
 */
public class MainController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NameController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NameController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String macFolder = "/Users/ryan/OneDrive WCTC/OneDrive - Waukesha County Technical College/Distributed Java/NamesApp_Store-RGK";
        String windowsFolder = "C:\\Users\\Ryan\\OneDrive - Waukesha County Technical College\\Distributed Java\\NamesApp_Store-RGK\\web";
        StaticPageService staticPageService = new StaticPageService("C:\\Users\\Ryan\\OneDrive - Waukesha County Technical College\\Distributed Java\\NamesApp_Store-RGK\\web\\header.html", "C:\\Users\\Ryan\\OneDrive - Waukesha County Technical College\\Distributed Java\\NamesApp_Store-RGK\\web\\footer.html");
        ProductService products = new ProductService("C:\\Users\\Ryan\\OneDrive - Waukesha County Technical College\\Distributed Java\\NamesApp_Store-RGK\\web\\productDB.txt");
        RequestDispatcher dispatcher = null;
        String id = request.getParameter("id");
        String product = request.getParameter("product");
        String cart = request.getParameter("cart");
        String addToCart = request.getParameter("addToCart");
        String search = request.getParameter("search");

        if ("all".equals(product)) {
            List<StaticPage> pageList = staticPageService.getAllStaticPages();
            List<Product> allProducts = products.getAllProducts();
            request.setAttribute("pageList", pageList);
            request.setAttribute("allProducts", allProducts);
            dispatcher = request.getRequestDispatcher("/products.jsp");
            //go to products.jsp
        } else if (product != null && !("all".equals(product))) {
            List<StaticPage> pageList = staticPageService.getAllStaticPages();
            List<Product> allProducts = products.getAllProducts();
            request.setAttribute("pageList", pageList);
            request.setAttribute("allProducts", allProducts);
            request.setAttribute("currentProductID", product);
            dispatcher = request.getRequestDispatcher("/productDetails.jsp");
            //go to productDetails.jsp
        }
        
        else if ("current".equals(cart)) {
            List<StaticPage> pageList = staticPageService.getAllStaticPages();
            request.setAttribute("pageList", pageList);
            request.setAttribute("addedToCart", "noItems");
            dispatcher = request.getRequestDispatcher("/cart.jsp");
            
        } else if (cart != null) {
            List<StaticPage> pageList = staticPageService.getAllStaticPages();
            List<Product> allProducts = products.getAllProducts();
            request.setAttribute("pageList", pageList);
            request.setAttribute("allProducts", allProducts);
            request.setAttribute("addedToCart", cart);
            dispatcher = request.getRequestDispatcher("/cart.jsp");
            
        } 
        
        else if (search != null) {
            List<StaticPage> pageList = staticPageService.findPages(search);
            request.setAttribute("pageList", pageList);
            dispatcher = request.getRequestDispatcher("/pageDetail.jsp");

            //go to nameDetail.jsp
        } else {
            List<StaticPage> pageList = staticPageService.getAllStaticPages();
            request.setAttribute("pageList", pageList);
            dispatcher = request.getRequestDispatcher("/home.jsp");
            //go to home.jsp
        }
        dispatcher.forward(request, response);

//            RequestDispatcher dispatcher =
//            request.getRequestDispatcher("/nameList.jsp");
//            request.setAttribute("name", name);
//            
//            dispatcher.forward (request, response);
//        processRequest(request, response);
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
        processRequest(request, response);
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
