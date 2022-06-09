package com.mh.jerseysamplepoc.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.jerseysamplepoc.Response.JsonResponse;
import com.mh.jerseysamplepoc.JerseyRestClient;
import com.mh.jerseysamplepoc.vo.Comments;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/commentsServlet"}, name = "commentsServlet")
public class CommentsServlet extends HttpServlet {
    JerseyRestClient jerseyRestClient;

    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        jerseyRestClient = new JerseyRestClient();
        JsonResponse jsonResponse = jerseyRestClient.getCommentsData();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<Comments>> mapType = new TypeReference<>() {
        };
        ArrayList<Comments> jsonToList = objectMapper.readValue(jsonResponse.getMessage(), mapType);
        request.setAttribute("commentsDetails", jsonToList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/comments.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
