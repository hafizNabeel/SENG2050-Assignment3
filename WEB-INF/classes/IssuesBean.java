import java.io.Serializable;

public class IssuesBean implements Serializable {

	private String issueId;
	private String personId;
	private String issesState;
	private String category;
	private String subCategory;
	private String title;
	private String description;
	private String reslotionDetails;
	private String dateReported;
	private String timeReported;
	private String dateSolved;

	public IssuesBean() {
	}

	public IssuesBean(String nissesState, String ncategory, String nsubCategory, String ntitle,
			String nreslotionDetails, String ndateReported, String ntimeReported, String ndateSolved) {
		this.issesState = nissesState;
		this.category = ncategory;
		this.subCategory = nsubCategory;
		this.title = ntitle;
		this.reslotionDetails = nreslotionDetails;
		this.dateReported = ndateReported;
		this.timeReported = ntimeReported;
		this.dateSolved = ndateSolved;
	}

	public void setIssueId(String id) {
		this.issueId = id;
	}

	public void setPersonId(String id) {
		this.personId = id;
	}

	public void setIssesState(String i) {

		dateSolved = i;
	}

	public void setDescription(String d) {
		this.description = d;
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

	public String getIssueId() {
		return issueId;
	}

	public String getPersonId() {
		return personId;
	}

	public String getDescription() {
		return description;
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

}
