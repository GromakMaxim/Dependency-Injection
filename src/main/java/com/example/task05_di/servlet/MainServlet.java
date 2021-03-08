package com.example.task05_di.servlet;

import com.example.task05_di.controller.UserController;
import com.example.task05_di.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "serv", value = "/")
public class MainServlet extends HttpServlet {
    private UserController controller;

    @Override
    public void init() {
        // отдаём список пакетов, в которых нужно искать аннотированные классы
        final var context = new AnnotationConfigApplicationContext("com.example.task05_di");
        controller = context.getBean(UserController.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //добавляем новую запись с юзером
        if (req.getRequestURI().contains("/add/useradd")) {
            req.getRequestDispatcher("/add-form.jsp").forward(req, resp);
        } else if (req.getRequestURI().contains("/add-success")) {
            controller.save(new User(req.getParameter("name"),
                    req.getParameter("surname"),
                    req.getParameter("age"),
                    req.getParameter("email")));
            req.getRequestDispatcher("/add-success.jsp").forward(req, resp);
        }

        if (req.getRequestURI().contains("/del/userdel")) {
            req.getRequestDispatcher("/del-form.jsp").forward(req, resp);
        } else if (req.getRequestURI().contains("/del-success")) {
            controller.deleteItem(Integer.parseInt(req.getParameter("id")));
            req.getRequestDispatcher("/del-success.jsp").forward(req, resp);
        }

        if (req.getRequestURI().contains("/result")) {
            PrintWriter pr = resp.getWriter();
            pr.println(controller.show());
        }
    }
}
