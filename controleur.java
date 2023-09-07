package com.example.sqltest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControleurServlet", urlPatterns = {"/controleur"})
public class controleur extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            request.getRequestDispatcher("impot.jsp").forward(request, response);
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double salaireAnnuel = Double.parseDouble(request.getParameter("salaireAnnuel"));
        int nbEnfants = Integer.parseInt(request.getParameter("nbEnfants"));
        boolean estMarie = request.getParameter("estMarie") != null;
        impot impot = new impot(salaireAnnuel, nbEnfants, estMarie);
        double impotCalcule = impot.calculerImpot();
        request.setAttribute("impot", impotCalcule);
        RequestDispatcher dispatcher = request.getRequestDispatcher("impot.jsp");
        dispatcher.forward(request, response);
    }

}
