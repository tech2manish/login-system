package server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail= request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		try {
			String url = "jdbc:mysql://junction.proxy.rlwy.net:10743/railway";
			String user ="root";
			String pass ="nXbjkivszOqezsOqJmquqfhdpVVwQCKN";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM userdetails WHERE email=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, userEmail);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			String userName = null;
			String actualPassword =null;
			while(resultSet.next()) {
				userName = resultSet.getString(1);
				actualPassword= resultSet.getString(3);
			}
			
			if(actualPassword==null) {
				response.sendRedirect("login.jsp?status=userNotExist");
				
			}else if(userPassword.equals(actualPassword)) {
				response.sendRedirect("dashboard.jsp?username="+userName);
			}else {
				response.sendRedirect("login.jsp?status=incorrectCredential");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
