package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ショッピング風DAOクラス. DBの商品(item)テーブルと購入履歴(history)のテーブルを扱う
 */
public class ShoppingDao {
    Connection con_ = null;
    ResultSet rs_ = null;
    PreparedStatement ps_ = null;
    ItemBean bean = null;

    public ShoppingDao() throws ClassNotFoundException, SQLException {
    	String url = "jdbc:mysql://localhost:3306/shopping_sample";
    	String user = "root";
    	String password = "root";
        // データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
        con_ = DriverManager.getConnection(url, user, password);
    }

    /**
     * データベースの全商品と在庫を取得します.
     *
     * @return	商品情報（ResultSet）
     * @throws SQLException
     */
    public ResultSet selectItem() throws SQLException {

        // SQL文を生成
        ps_ = con_.prepareStatement(
                "SELECT item.item_id, item.item_name, item.price, stock.quantity FROM item inner join stock on item.item_id = stock.item_id"
        );

        // SQLを実行
        rs_ = ps_.executeQuery();

        if (rs_.next()) {
        }
		return rs_;
    }

    /**
     * 商品IDを基にデータベースの商品情報と在庫を取得します.
     *
     * @return	商品情報（ResultSet）
     * @param item_id 商品ID
     * @throws SQLException
     */
    public ResultSet selectItem(String item_id) throws SQLException {
        // SQL文を生成
        ps_ = con_.prepareStatement(
                "SELECT item.item_name, item.price, stock.quantity FROM item inner join stock on item.item_id = stock.item_id WHERE item.item_id = ?"
        );
        // SQL文に商品IDを設定
        ps_.setString(1, item_id);
        // SQLを実行
        rs_ = ps_.executeQuery();

        return rs_;
    }

    /**
     * ユーザの購入履歴を取得します.
     *
     * @param user_id
     * @return	購入履歴（ResultSet）
     * @throws SQLException
     */
    public ResultSet selectHistory(String user_id) throws SQLException {
        // SQL文を生成
        ps_ = con_.prepareStatement("SELECT history.item_id, item.item_name, history.quantity FROM history inner join item on history.id = ? AND history.item_id = item.item_id");
        ps_.setString(1, user_id);

        // SQLを実行
        rs_ = ps_.executeQuery();
        return rs_;
    }

    /**
     * 商品IDを基にデータベースの在庫を更新（マイナス）します.
     *
     * @param item_id;
     * @param purchased_num 購入数
     * @throws SQLException
     */
    public void updateItem(String item_id, int purchased_num) throws SQLException {
         // SQL文を生成
        /* TODO:2-⑨update文を追加
         在庫から購入数を引く
         */
        ps_ = con_.prepareStatement("UPDATE stock set quantity = quantity - ? WHERE item_id = ?");

        // SQL文に数量を設定
        ps_.setInt(1, purchased_num);
        // SQL文に商品IDを設定
        ps_.setString(2, item_id);
        // SQLを実行
        ps_.executeUpdate();
    }

    /**
     * 購入履歴テーブルを更新します.
     *
     * @param user_id	ユーザID
     * @param item_id 商品ID
     * @param purchased_num 購入数
     * @throws SQLException
     */
    public void updateHistory(String user_id, String item_id, int purchased_num) throws SQLException {
         // SQL文を生成
        // TODO:2-⑩insert文を追加
        ps_ = con_.prepareStatement("INSERT into history(id, item_id, quantity) VALUES (?, ?, ?)");

        ps_.setString(1, user_id);
        ps_.setString(2, item_id);
        ps_.setInt(3, purchased_num);

        ps_.executeUpdate();
    }

    /**
     * コネクションをクローズします.
     */
    public void close() {
        try {
            if (con_ != null){
            	con_.close();
            }
            if (ps_ != null) {
                ps_.close();
            }
            if (rs_ != null) {
                rs_.close();
            }
        } catch (SQLException se) {
            // データベースとの接続解除に失敗した場合
            se.printStackTrace();
        }
    }
}