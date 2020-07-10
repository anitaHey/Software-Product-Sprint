package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** Servlet responsible for creating new message. */
@WebServlet("/new-message")
public class NewMessageServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String username = request.getParameter("username");
    String content = request.getParameter("message");
    long timestamp = System.currentTimeMillis();

    Date nowTime = new Date(timestamp);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String date = formatter.format(nowTime);

    Entity messageEntity = new Entity("Message");
    messageEntity.setProperty("username", username);
    messageEntity.setProperty("content", content);
    messageEntity.setProperty("date", date);
    messageEntity.setProperty("timestamp", timestamp);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(messageEntity);

    response.sendRedirect("/index.html");
  }
}