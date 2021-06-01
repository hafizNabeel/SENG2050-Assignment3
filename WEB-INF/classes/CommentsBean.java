import java.io.Serializable;

public class CommentsBean implements Serializable {

  private String personID;
  private String description;

  public CommentsBean() {
  }

  public CommentsBean(String pd, String nd) {

    this.personID = pd;
    this.description = nd;

  }

  public void setPersonId(String pd) {

    personID = pd;
  }

  public void setDescription(String nd) {

    description = nd;
  }

  public String getPersonId() {
    return personID;
  }

  public String getDescription() {
    return description;
  }

}