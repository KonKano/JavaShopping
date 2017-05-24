package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログインDAOクラス.
 */
public class LoginDao {

	Connection con_ = null;
    ResultSet rs_ = null;
    PreparedStatement ps_ = null;
    LoginUserBean bean = null;

    public LoginDao() throws ClassNotFoundException, SQLException {
    	String url = "jdbc:mysql://localhost:3306/shopping_sample";
    	String user = "root";
    	String password = "root";
        // データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
        con_ = DriverManager.getConnection(url, user, password);
    }

    /**
     * データベースから指定されたIDとパスワードを使ってユーザ情報を検索します.
     *
     * @param id	ログインID
     * @param pass	パスワード
     * @return	ユーザ情報（ResultSet）
     * @throws SQLException
     */
    public LoginUserBean selectUser(String id, String pass) throws SQLException {

    	try {
        // SQL文を生成
        ps_ = con_.prepareStatement("SELECT * FROM user WHERE id = ? AND pass = ?");

        // 生成したSQL文の「？」の部分にIDとパスワードをセット
        ps_.setString(1, id);
        ps_.setString(2, pass);

        // SQLを実行
        rs_ = ps_.executeQuery();
        if (rs_.next()) {
        	bean = new LoginUserBean();
        	bean.setId(rs_.getString("id"));
        	bean.setPass(rs_.getString("pass"));
        	bean.setName(rs_.getString("name"));
        	bean.setAge(rs_.getInt("age"));
        }
    	} catch (SQLException ce){
    		ce.printStackTrace();
    	}
        return bean;
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