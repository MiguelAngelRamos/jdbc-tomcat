package com.kibernumacademy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kibernumacademy.controller.UserController;
import com.kibernumacademy.entity.Usuario;

@WebServlet("/ServletUsers")
public class ServletUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        UserController userController = new UserController();
        System.out.println("Servlet Student inside");
        List<Usuario> users = userController.findAllUsers();
        System.out.println(users);
        
        // Establecer el tipo de contenido a HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Escribir el HTML directamente a la respuesta
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Lista de Usuarios</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Usuarios</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Nombre</th><th>Email</th><th>Username</th><th>Fecha de Registro</th></tr>");

        for(Usuario user : users) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getNombre() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getFechaRegistro() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
