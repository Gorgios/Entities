package pl.edu.ug.tent.springweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        out.println("<html><body>");
        out.println("<form action ='/calc' method ='POST'>"
                + "<input type='text' name='a'><br>"
                + "<input type='radio' name='operator' value='+' checked>+<br>"
                + "<input type='radio' name='operator' value='-'>-<br>"
                + "<input type='radio' name='operator' value='*'>*<br>"
                + "<input type='radio' name='operator' value='/'>/<br>"
                + "<input type='text' name='b'><br>"
                + "<input type='submit' name='=' value='='>"
                + "</form>");
        out.println("<form action='/list' method='GET'> " +
                "<input type = 'submit' value='Zobacz Twoje obliczenia'> " +
                "</form>");

        out.println("</body></html>");

    }
}

