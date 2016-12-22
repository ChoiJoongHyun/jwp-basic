package core.http;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.web.filter.ResourceFilter;
import next.controller.Controller;
import next.controller.ListUserController;



@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ResourceFilter.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get, post, put, delete 다 받을수 있다.
		
		logger.debug("DispatcherServlet start doget req.getRequestURI() : " + req.getRequestURI());
		
		//컨트롤 객체생성
		Controller controller = RequestMapping.getController(req.getRequestURI());
		
		try {
			//컨트롤 실행
			String url = controller.execute(req, resp);
			logger.debug("DispatcherServlet start doget url : " + url);
			move(url, req, resp);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void move(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(url.startsWith("redirect:")) {
			resp.sendRedirect(url.split("redirect:")[1]);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
		}
	}
}
