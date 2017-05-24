<?xml version="1.0" encoding="UTF-8" ?>
<%-- login失敗 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- ログインエラー画面 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>エラー画面</title>
      <link href="css/shopping.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
		<main>
            <h1>ログインエラー</h1>
            <p>入力されたユーザは存在しません...</p>
            <form>
                <a class="common_button" href="./LoginServlet?submit=logout">戻る</a>
            </form>
		</main>
    </body>
</html>