import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.io.*;

public class IssuesBean implements Serializable {
	private String issesState;
	private String category;
	private String subCategory;
	private String title;
	private String reslotionDetails;
	private String dateReported;
	private String timeReported;
	private String dateSolved;
	private String personID;

	public IssuesBean() {
	}

	public IssuesBean(String nissesState, String ncategory, String nsubCategory, String ntitle,
			String nreslotionDetails, String ndateReported, String ntimeReported, String ndateSolved,
			String npersonID) {
		this.issesState = nissesState;
		this.category = ncategory;
		this.subCategory = nsubCategory;
		this.title = ntitle;
		this.reslotionDetails = nreslotionDetails;
		this.dateReported = ndateReported;
		this.timeReported = ntimeReported;
		this.dateSolved = ndateSolved;
		this.personID = npersonID;
	}

	public void setIssesState(String i) {

		dateSolved = i;
	}

	public void setCategory(String c) {

		category = c;
	}

	public void setSubCategory(String s) {

		subCategory = s;
	}

	public void setTitle(String t) {

		title = t;
	}

	public void setReslotionDetails(String r) {

		reslotionDetails = r;
	}

	public void setDateReported(String dr) {

		dateReported = dr;
	}

	public void setTimeReported(String tr) {

		timeReported = tr;
	}

	public void setDateSolved(String ds) {

		dateSolved = ds;
	}

	public String getIssesState() {

		return issesState;
	}

	public String getCategory() {

		return category;
	}

	public String getSubCategory() {

		return subCategory;
	}

	public String getTitle() {

		return title;
	}

	public String getReslotionDetails() {

		return reslotionDetails;
	}

	public String getDateReported() {

		return dateReported;
	}

	public String getTimeReported() {

		return timeReported;
	}

	public String getDateSolved() {

		return dateSolved;
	}

	public String getPersonID() {

		return personID;
	}

	public static String generateString() {
		String uuid = UUID.randomUUID().toString();
		String upToNCharacters = uuid.substring(0, 4);
		return upToNCharacters;
	}

	public void AddIssue(IssuesBean obj) {
		try {
			String query = "INSERT INTO ISSUES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			Connection connection = ConfigBean.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, generateString());
			statement.setString(2, obj.personID);
			statement.setString(3, obj.issesState);
			statement.setString(4, obj.category);
			statement.setString(5, obj.subCategory);
			statement.setString(6, obj.title);
			statement.setString(7, obj.reslotionDetails);
			statement.setString(8, obj.dateReported);
			statement.setString(9, obj.timeReported);
			statement.setString(10, obj.dateSolved);
			statement.setString(11, null);
			statement.setString(12, null);

			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		;

	}
}
