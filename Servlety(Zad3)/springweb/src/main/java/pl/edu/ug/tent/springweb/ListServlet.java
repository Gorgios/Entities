package pl.edu.ug.tent.springweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    public static List<Operation> operations = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        out.println("<html><body>");
        for (Operation i : operations)
            out.println("<li>" + i + "</li>");
        out.println("<form action='/calc' method='GET'> " +
                "<input type = 'submit' value='Wroc do kalkulatora'> " +
                "</form>");
        out.println("</body></html>");

    }
}
