package org.scoula.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "my", value = "/my")
public class MyServlet extends HelloServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet=================");
    }

    @Override
    public void destroy() {
        System.out.println("서블릿 제거되기 전에 꼭 실행할 부분 코드");
    }

    @Override
    public void init() {
        System.out.println("서블릿 생성될 때 꼭 초기화할 부분 코드");
    }
}
