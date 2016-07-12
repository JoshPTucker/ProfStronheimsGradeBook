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

/**
 * Servlet implementation class Assignments
 */
@WebServlet("/Assignments")
public class Assignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ArrayList<Object[]> averages = new ArrayList<Object[]>();
		List<Object[]> rpt= gbUtil.StrongheimAverages();
		 averages.addAll(rpt);
		 //averages.addAll(gbUtil.StrongheimAverages());
//		 for (Object[] r: averages){
//		 String min =r[0].toString();
//		 String max =r[1].toString();
//		 String average=r[2].toString();
//		 String type=r[3].toString();
//		 }
		 session.setAttribute("overallaverage", averages);
		 doPost(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	ArrayList<Psassignment> allassignments = new ArrayList<Psassignment>();
	List <Psassignment> assign= gbUtil.allAssignments();
	allassignments.addAll(assign);
	session.setAttribute("allassignments", allassignments);
	 String nextURL="/assignments.jsp";
		 response.sendRedirect(request.getContextPath() + nextURL);
	}
}
