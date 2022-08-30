package site.metacoding.ds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override()
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	// 무슨 요청을 해도 다 doPorcess 를 때리게 만든다.
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doProcess요청됨");
		String httpMethod = req.getMethod();
		System.out.println(httpMethod);
		String identifier = req.getRequestURI(); // 8000 뒤의 주소를 파싱해줌
		System.out.println(identifier);
		
		// 공통 로직 처리 원래는 유저컨트롤러에 조인해도 해야되고 로그인에도 해야되고, 
		
		UserController c = new UserController();
		if(identifier.equals("/join")) {
			c.join();
		}else if(identifier.equals("/login")) {
			c.login();
		}else {
			System.out.println("잘못된 요청입니다.");
		}
	}
}
