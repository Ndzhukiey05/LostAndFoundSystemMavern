
package lostandfoundsystem.domain;


public class Item {
    private int item_id;
    private String itemName, category,description, status;
    
    

    public Item() {
    }

    public Item(int item_id, String itemName, String category, String description, String status) {
        this.item_id = item_id;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.status = status;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" + "item_id=" + item_id + ", itemName=" + itemName + ", category=" + category + ", description=" + description + ", status=" + status + '}';
    }

    
    
   
}
