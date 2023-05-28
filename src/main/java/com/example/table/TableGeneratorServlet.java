package com.example.table;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TableGeneratorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        int rows = Integer.parseInt(req.getParameter("rows"));
        int columns = Integer.parseInt(req.getParameter("columns"));
        String bgColor = req.getParameter("bgColor");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Generated Table</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>" + title + "</h1>");
        out.println("    <table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" bgcolor=\"" + bgColor + "\">");

        for (int i = 0; i < rows; i++) {
            out.println("        <tr>");
            for (int j = 0; j < columns; j++) {
                out.println("            <td>Cell (" + i + ", " + j + ")</td>");
            }
            out.println("        </tr>");
        }

        out.println("    </table>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}