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
import java.sql.SQLException;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			String url = "jdbc:mysql://junction.proxy.rlwy.net:10743/railway";
			String user ="root";
			String pass ="nXbjkivszOqezsOqJmquqfhdpVVwQCKN";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pass);
			String query ="INSERT INTO userdetails VALUES (?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			
			preparedStatement.execute();
			
//			System.out.println("Signup Successfull.");
			
			preparedStatement.close();
			connection.close();
			
			response.sendRedirect("confirmation.jsp?status=success&test="+username);
		}catch(SQLException e) {
			if(e.getErrorCode() == 1062) {
				response.sendRedirect("confirmation.jsp?status=alreadyExist");
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("confirmation.jsp?status=error");
		}
		
	}

}
