package com.mh.jerseysamplepoc.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.jerseysamplepoc.RestClient;
import com.mh.jerseysamplepoc.vo.Posts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/PostsServlet"}, name = "PostsServlet")
public class PostsServlet extends HttpServlet {
    RestClient restClient;

    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        restClient = new RestClient();
        String jsonString = restClient.getPostsData();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<Posts>> mapType = new TypeReference<>() {
        };
        ArrayList<Posts> jsonToList = objectMapper.readValue(jsonString, mapType);
        request.setAttribute("postsDetails", jsonToList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/posts.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
