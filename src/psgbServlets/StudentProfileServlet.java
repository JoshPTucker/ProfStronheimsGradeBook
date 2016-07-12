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
 * Servlet implementation class StudentProfileServlet
 */
@WebServlet("/StudentProfileServlet")
public class StudentProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Psstudent stud=(Psstudent) session.getAttribute("currstudent");
		int stid=(int) stud.getStudentid();
		
		ArrayList<Object[]> studentaverages = new ArrayList<Object[]>();
		List<Object[]> rpt= gbUtil.StrongheimAveragesStudent(stid);
		studentaverages.addAll(rpt);
		
		session.setAttribute("studentaverages", studentaverages);
		String nextURL="/studentprofile.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Psstudent stu=(Psstudent) session.getAttribute("currstudent");
		int sid=(int) stu.getStudentid();
		
		ArrayList<Psassignment> assignments = new ArrayList<Psassignment>();
		List <Psassignment> assign= gbUtil.assignmentsOfStudent(sid);
		assignments.addAll(assign);
		session.setAttribute("assignments", assignments);
		 
		String nextURL="/studentprofile.jsp";
		 response.sendRedirect(request.getContextPath() + nextURL);
	}

}
