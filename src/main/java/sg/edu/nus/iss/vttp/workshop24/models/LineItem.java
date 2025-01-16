package sg.edu.nus.iss.vttp.workshop24.models;

import java.io.Serializable;

public class LineItem implements Serializable{
    private Integer itemId;
    private String description;
    private Integer quantity;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
