
package lostandfoundsystem.domain;


public class Report {
    
  private int reportID, personID, itemID;
  private String dateLost, location, itemType;
  private byte[] imageData;

    public Report() {
    }

    public Report(int reportID, int personID, int itemID, String dateLost, String location, byte[] imageData, String itemType) {
        this.reportID = reportID;
        this.personID = personID;
        this.itemID = itemID;
        this.dateLost = dateLost;
        this.location = location;
        this.imageData = imageData;
        this.itemType = itemType;
        
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getDateLost() {
        return dateLost;
    }

    public void setDateLost(String dateLost) {
        this.dateLost = dateLost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Report{" + "reportID=" + reportID + ", personID=" + personID + ", itemID=" + itemID + ", dateLost=" + dateLost + ", location=" + location + ", itemType=" + itemType + ", imageData=" + imageData + '}';
    }
    
    
}
