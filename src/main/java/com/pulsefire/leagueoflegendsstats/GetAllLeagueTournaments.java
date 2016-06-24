package com.pulsefire.leagueoflegendsstats;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Balram
 */
@WebServlet(name = "GetAllLeagueTournaments", urlPatterns = {"/GetAllLeagueTournaments"})
public class GetAllLeagueTournaments extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
           GetAllLeagueTournamentsHelper objGetAllLeagueTournamentsHelper=new GetAllLeagueTournamentsHelper();
          LeagueDBOperations objd=new LeagueDBOperations();
          objd.insertLeagueRecord(objGetAllLeagueTournamentsHelper.getAllTournamentJSON());

           //out.print(objGetAllLeagueTournamentsHelper.getAllTournamentJSON());
  //        League[] objarr=new League[2];

//          objarr[0]=new League("slug", "IN-LCS1", "IN", "none", "23-06-2016", "24-06-2016", new JSONObject(), new JSONObject());
//          objarr[1]=new League("slug", "IN-LCS2", "IN2", "none", "23-06-2016", "24-06-2016", new JSONObject(), new JSONObject());
          
          
//          LeagueDBOperations objd=new LeagueDBOperations();
//          objd.insertLeagueRecord(objarr);
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
        processRequest(request, response);
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
