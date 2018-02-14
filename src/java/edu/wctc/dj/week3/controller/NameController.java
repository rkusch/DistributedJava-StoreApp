/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week3.controller;

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
public class NameController extends HttpServlet {

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
        String folder = "/Users/ryan/OneDrive WCTC/OneDrive - Waukesha County Technical College/Distributed Java/NamesApp_Store-RGK";
        StaticPageService staticPageService = new StaticPageService("/Users/ryan/OneDrive WCTC/OneDrive - Waukesha County Technical College/Distributed Java/NamesApp_Store-RGK/web/header.html","/Users/ryan/OneDrive WCTC/OneDrive - Waukesha County Technical College/Distributed Java/NamesApp_Store-RGK/web/footer.html");
        RequestDispatcher dispatcher = null;
        String id = request.getParameter("id");
        String search = request.getParameter("search");

        if (id != null) {
            StaticPage name = staticPageService.getID(id);
            request.setAttribute("name", name);
            dispatcher = request.getRequestDispatcher("/pageDetail.jsp");

            //go to nameDetail.jsp
        } else if (search != null) {
            List<StaticPage> pageList = staticPageService.findPages(search);
            request.setAttribute("pageList", pageList);
            dispatcher = request.getRequestDispatcher("/pageList.jsp");

            //go to nameDetail.jsp
        } else if (search == "a") {
            List<StaticPage> pageList = new ArrayList<StaticPage>();
            StaticPage page3 = new StaticPage("4", "hello");
            pageList.add(page3);
            request.setAttribute("pageList", pageList);
            dispatcher = request.getRequestDispatcher("/products.jsp");

            //go to nameDetail.jsp
        } else {
            List<StaticPage> pageList = staticPageService.getAllStaticPages();
            request.setAttribute("pageList", pageList);
            dispatcher = request.getRequestDispatcher("/pageList.jsp");
            //go to nameList.jsp
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
