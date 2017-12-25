package late.kbase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 知识库接收接口
 * 
 * @projectName kbase
 * @packageName late.kbase
 * @fileName KnowledgeServlet.java
 * @author chijingjia
 * @createTime :2017年12月1日 上午11:34:31
 * @version: v1.0
 */
public class KnowledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KnowledgeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger logger = Logger.getLogger(this.getClass());
		logger.debug("Hello World");
		response.getWriter().write(request.getRemoteHost());
	}

}
