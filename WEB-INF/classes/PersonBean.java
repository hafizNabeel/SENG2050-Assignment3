import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class PersonBean implements Serializable {

	private String personID;
	private String fname;
	private String lname;
	private String email;
	private String userPassword;
	private String phoneNo;
	private String roleInSystem;
	private boolean status = false;

	public PersonBean() {
	}

	public PersonBean(String nFname, String nLname, String nemail, String nuserPassword, String nphoneNo,
			String nroleInSystem) {

		this.fname = nFname;
		this.lname = nLname;
		this.email = nemail;
		this.userPassword = nuserPassword;
		this.phoneNo = nphoneNo;
		this.roleInSystem = nroleInSystem;
		this.status = false;
	}

	public void setStatus(boolean v) {

		this.status = v;
	}

	public void setPersonId(String id) {

		this.personID = id;
	}

	public void setFname(String f) {

		this.fname = f;
	}

	public void setLname(String l) {

		this.lname = l;
	}

	public void setEmail(String e) {

		this.email = e;
	}

	public void setUserPassword(String u) {

		this.userPassword = u;
	}

	public void setPhoneNo(String p) {
		this.phoneNo = p;
	}

	public void setRoleInSystem(String r) {

		this.roleInSystem = r;
	}

	public boolean getStatus() {

		return status;
	}

	public String getPersonId() {

		return personID;
	}

	public String getFname() {

		return fname;
	}

	public String getLname() {

		return lname;
	}

	public String getEmail() {

		return email;
	}

	public String getUserPassword() {

		return userPassword;
	}

	public String getPhoneNo() {

		return phoneNo;
	}

	public String getRoleInSystem() {

		return roleInSystem;
	}

	public void login(String userName, String password) {
		try {
			String query = "SELECT * FROM person Where [email]=? AND [userPassword]=? ";
			Connection connection = ConfigBean.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				status = true;
				this.setPersonId(result.getString("personID"));
				this.setFname(result.getString("Fname"));
				this.setLname(result.getString("Lname"));
				this.setEmail(result.getString("email"));
				this.setPhoneNo(result.getString("phoneNo"));
				this.setUserPassword(result.getString("userPassword"));
				this.setRoleInSystem(result.getString("roleInSystem"));
			}

			result.close();
			statement.close();
			connection.close();
		}

		catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		;
	}

	public void addUser(String fn, String ln, String em, String pass, String pn) {
		int uniqueID;
		uniqueID = ThreadLocalRandom.current().nextInt();
		if ((uniqueID == 0) || (uniqueID < 0)) {
			if (uniqueID < 0) {
				uniqueID *= (-1);
			}
			uniqueID += 1;
		}

		try {
			String query = "INSERT INTO person VALUES (?, ?, ?, ?, ?, ?, ?)";
			Connection connection = ConfigBean.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, uniqueID);
			statement.setString(2, fn);
			statement.setString(3, ln);
			statement.setString(4, em);
			statement.setString(5, pass);
			statement.setString(6, pn);
			statement.setString(7, "User");

			statement.executeUpdate();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		;
	}

	public boolean exist(String userName) {
		boolean check = false;
		try {
			String query = "SELECT * FROM person Where [email]=? ";
			Connection connection = ConfigBean.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				result.close();
				statement.close();
				connection.close();
				check = true;
			}

			result.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		;
		return check;
	}

}
