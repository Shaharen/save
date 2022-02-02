package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;
import Model.MemberDTO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.memberLogin(id, pw);

		// 로그인 후 세션 저장후 넘겨줘야 메인페이지에서 닉네임으로 출력가능
		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			response.sendRedirect("main.jsp");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 실패');");
			out.print("location.href='main.jsp';");
			out.print("</script>");
		}

	}
}
