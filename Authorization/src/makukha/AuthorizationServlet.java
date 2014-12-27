package makukha;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AuthorizationServlet extends HttpServlet {

	private String user = "Max";
	private String password = "123";

	private String form;
	{
		form = "<form method=\"post\">"
				+ "Input your data:"
				+ "<br>"
				+ "<label>Login <input type=\"text\" name=\"login\"></label>"
				+ "<label>Password <input type=\"password\" name=\"password\"></label>"
				+ "<br><input type = \"submit\" value = \"Ok\">";
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println(form);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		String responce = "";

		if ((login.equals("")) || (pass.equals(""))) {
			responce = "You have not entered your data!";
			resp.getWriter().println(responce);
		} else if (!login.equals(user)) {
			responce = "This user do not exist!";
			resp.getWriter().println(responce);
		} else if (!pass.equals(password)) {
			responce = "Wrong password!";
			resp.getWriter().println(responce);
		} else {
			responce = "Hello, dear Max!";
			resp.getWriter().println(responce);
		}
	}
}