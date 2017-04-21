package servlet;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
/**
 * Created by baofeng on 2017/4/14.
 */
public class MusicServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader("../songs.json"));
        char[] songs = new char[10000];
        bufferedReader.read(songs);
        String s = new String(songs);
        writer.write(s);
        writer.close();
    }
}
