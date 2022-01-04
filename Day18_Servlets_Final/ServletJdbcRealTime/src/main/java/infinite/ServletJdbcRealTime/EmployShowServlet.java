package infinite.ServletJdbcRealTime;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployShowServlet
 */
public class EmployShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployDAO dao = EmployDAO.getInstance();
		PrintWriter out = response.getWriter();
		try {
			out.println("<table border=3><tr><th>EmployNo</th><th>Employ Name</th>");
			out.println("<th>Gender</th><th>Department</th><th>Designation</th>");
			out.println("<th>Salary</th>");

			Employ[] employArray = dao.showEmploy();
			for (Employ employ : employArray) {
								out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" +employ.getEmpno() + "</td>");
				out.println("<td>" +employ.getName() + "</td>");
				out.println("<td>" +employ.getGender() + "</td>");
				out.println("<td>" +employ.getDept() + "</td>");
				out.println("<td>" +employ.getDesig() + "</td>");
				out.println("<td>" +employ.getBasic() + "</td>");
				out.println("</tr>");
				
			}
			out.println("</table>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
