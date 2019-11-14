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

@WebServlet("/calc")
public class DataServlet extends HttpServlet {
    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errInfoA = "";
        String errInfoB = "";
        String result = "";
        PrintWriter out = resp.getWriter();
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String operator = req.getParameter("operator");
        if ((isNumeric(a) && isNumeric(b))) {
            Operation calc = new Operation();
            calc.setA(Float.parseFloat(a));
            calc.setB(Float.parseFloat(b));
            calc.setOperator(operator.charAt(0));
            result = calc.Calc();
            ListServlet.operations.add(calc);
        } else {
            if (!isNumeric(a))
                errInfoA = "Bad input of A";
            if (!isNumeric(b))
                errInfoB = "Bad input of B";
        }

        resp.setContentType("text/html");

        resp.setContentType("text/html");

        out.println("<html><body>");
        out.println("<form action ='/calc' method ='POST'>"
                + "<input type='text' name='a' value=" + result + ">" + errInfoA + "<br>"
                + "<input type='radio' name='operator' value='+' checked>+<br>"
                + "<input type='radio' name='operator' value='-'>-<br>"
                + "<input type='radio' name='operator' value='*'>*<br>"
                + "<input type='radio' name='operator' value='/'>/<br>"
                + "<input type='text' name='b'>" + errInfoB + "<br>"
                + "<input type='submit' name='=' value='='>"
                + "</form>");
        out.println("<form action='/list' method='GET'> " +
                "<input type = 'submit' value='Zobacz Twoje obliczenia'> " +
                "</form>");

        out.println("</body></html>");
    }
}
