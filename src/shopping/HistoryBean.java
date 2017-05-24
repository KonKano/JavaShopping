package shopping;

import java.io.Serializable;

/**
 * HistoryBean
 */
public class HistoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    String item_id_; // 商品ID
    String item_name_; // 商品名
    int quantity_; // 購入した数

    public HistoryBean() {
        item_id_ = "";
        item_name_ = "";
        quantity_ = 0;
    }

    public HistoryBean(String item_id, String item_name, int quantity) {
        item_id_ = item_id;
        item_name_ = item_name;
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

    public void setQuantity(int quantity){
        quantity_ = quantity;
    }

    public int getQuantity(){
        return quantity_;
    }

}