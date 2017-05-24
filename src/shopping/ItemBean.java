package shopping;

import java.io.Serializable;

public class ItemBean implements Serializable{
    private static final long serialVersionUID = 1L;

    String item_id_;
    String item_name_;
    int price_;
    int quantity_;

    public ItemBean(){
        item_id_ = "";
        item_name_ = "";
        price_ = 0;
        quantity_ = 0;
    }

    public ItemBean(String item_id, String item_name, int price, int quantity){
        item_id_ = item_id;
        item_name_ = item_name;
        price_ = price;
        quantity_ = quantity;
    }

    public void setItemId(String item_id){
        item_id_ = item_id;
    }

    public String getItemId(){
        return item_id_;
    }

    public void setItemName(String item_name){
        item_name_ = item_name;
    }

    public String getItemName(){
        return item_name_;
    }

     public void setPrice(int price){
        price_ = price;
    }

    public int getPrice(){
        return price_;
    }

    public void setQuantity(int quantity){
        quantity_ = quantity;
    }

    public int getQuantity(){
        return quantity_;
    }

}