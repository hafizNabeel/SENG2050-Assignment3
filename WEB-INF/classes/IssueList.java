import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssueList implements Serializable {
    private ArrayList<IssuesBean> issues = new ArrayList<IssuesBean>();

    public IssueList() {

    }

    public void setIssues(ArrayList<IssuesBean> issue) {
        this.issues = issue;
    }

    public ArrayList<IssuesBean> getIssues() {
        return issues;
    }

    private void loadIssues() {
        int i = 0;
        ArrayList<IssuesBean> tempList = new ArrayList<IssuesBean>();
        String query = "SELECT * FROM Issues";
        try {
            Connection connection = ConfigBean.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                tempList.add(new IssuesBean());
                tempList.get(i).setIssueId(result.getString("issueID"));
                tempList.get(i).setPersonId(result.getString("personID"));
                tempList.get(i).setIssesState(result.getString("issueState"));
                tempList.get(i).setCategory(result.getString("category"));
                tempList.get(i).setSubCategory(result.getString("subCategory"));
                tempList.get(i).setTitle(result.getString("title"));
                tempList.get(i).setReslotionDetails(result.getString("resolutionDetails"));
                tempList.get(i).setDateReported(result.getString("dateReported"));
                tempList.get(i).setTimeReported(result.getString("timeReported"));
                tempList.get(i).setDateSolved(result.getString("dateSolved"));
                tempList.get(i).setDescription(result.getString("description"));
                i++;
            }
            result.close();
            statement.close();
            connection.close();
            this.setIssues(tempList);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }
    }

}
