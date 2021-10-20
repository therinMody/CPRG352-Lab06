/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 821320
 */
public class ShoppingListServlet extends HttpServlet {
    
    public ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            String action = request.getParameter("action");

            if (action.equals("logout")) {
                
                items.clear();
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }  
        
        } catch (Exception ex) {
            
            if (session.getAttribute("username") != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        switch (action) {
            case "add":
                
                String addition = request.getParameter("newItem");
                
                if (!addition.isEmpty()) {
                    items.add(addition);
                    session.setAttribute("items", items);
                }
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
                
            case "delete":
                
                String deletion = request.getParameter("item");
                items.remove(deletion);
                if (items.isEmpty()) {
                    session.setAttribute("items", null);
                }

                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
                
            case "register":
                
                String username = request.getParameter("username");
                
                if (!username.isEmpty()) {
                    session.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    return;
                } else {
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
                }
                
                
            default:
                return;

        }
 
    }
    

}
