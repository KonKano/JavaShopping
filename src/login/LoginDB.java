package login;

import java.sql.SQLException;

public class LoginDB extends Login {

    @Override
    public LoginUserBean getUserData(String id, String pass) {

        LoginUserBean bean = null;
        LoginDao dao = null;

        try {
            // DAOクラスをインスタンス化
            dao = new LoginDao();
            // 画面で入力されたIDとパスワードを基にDB検索を実行
            bean = dao.selectUser(id, pass);


        } catch (SQLException e) {
            e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
            // 処理終了時に各接続を解除
            if (dao != null) {
                dao.close();
            }
        }
        return bean;
    }
}