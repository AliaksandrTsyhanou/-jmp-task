package by.epam.jmp;

import by.epam.jmp.BO.LoginBO;
import com.epam.jmp.HelloUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexandr on 28.02.2016.
 */
@WebServlet(name = "LoginServlet",
            urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Inject
    LoginBO loginBO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String helloMessage = HelloUtil.createHelloMessage(loginBO.getLoginName(5));
        request.setAttribute("helloMessage", helloMessage);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
