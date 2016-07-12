package psgbServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.gbUtil;
import model.Psassignment;
import model.Psstudent;


/**
 * Servlet implementation class GradebookServlet
 */
@WebServlet("/GradebookServlet")
public class GradebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradebookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				//PrintWriter out = response.getWriter();
				HttpSession session = request.getSession();
				int studentid=Integer.parseInt(request.getParameter("studentid"));
				Psstudent currstudent=gbUtil.singleStudent(studentid);
				session.setAttribute("currstudent", currstudent);		
		
				//System.out.println(assignments.toString());
				String nextURL="/studentprofile.jsp";
				 response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		ArrayList<Psstudent> students = new ArrayList<Psstudent>();
		students.addAll(gbUtil.psstudents());
		session.setAttribute("students", students);
		//System.out.println(students.toString());
		String nextURL="/gradebook.jsp";
		 response.sendRedirect(request.getContextPath() + nextURL);
	}

}
