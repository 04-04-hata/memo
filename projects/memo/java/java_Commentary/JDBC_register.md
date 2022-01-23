〜JDBCでのデータ登録、更新、削除〜

Connectionを作るところまではデータの抽出と同じ。

例:insert↓

PreparedStatement statement = connection.prepareStatement("insert into user (email, name) values (?, ?)")

↑のようにパラメーターの部分をプレイスホルダー(?)に置き換える。<br>
パラメーターを埋め込む処理も抽出の時と同じように↓する<br>

statement.setString(1, "aaa@aaa.aaa");
statement.setString(2, "山田太郎");

今回のSQLには?が2つあるのでsetStringの第一引数に、1、2 と順番に指定していく。<br>

SQLの実行は↓

boolean result = statement.execute();

↑の戻り値のboolean型のresultがtrueの場合、statement.getResultSet()でResultSetが取得できる。resultがfalseの場合、statement.getUpdateCount()で変更された行数が取得できる。

実行結果が必要ない場合は単に、statement.execute();としてもいい。<br>

例:update↓

PreparedStatement statement = connection.prepareStatement("update user set email = ?, name = ? where id = ?");
statement.setString(1, "bbb@bbb.bbb");
statement.setString(2, "山田三郎");
statement.setLong(3, 1L);
statement.execute();

例:delete↓

PreparedStatement statement = connection.prepareStatement("delete from user where id = ?");
statement.setString(1, 1L);
statement.execute();

〜JCBCでの例外処理〜

JCBC接続処理では様々な理由で例外が発生する。
ユーザー名、パスワードの間違い、テーブルがない、カラムがない、Javaとデータベースの型不一致のような、根本的な設定の不備やコードの記述ミスのようなものや、プライマリーキーの重複、SQLの構文エラーなど、実行時に発生しうるものがあります。<br>
これらの例外を適切に処理できないと、データベースからのデータ取得、データベースへのデータ登録に失敗します。また、業務ロジック上、不正なデータがデータベースに登録されてしまうことにもなりかねません。<br>

〜SQLExceptionの処理〜

JDBC接続で発生する例外は、java.sql.SQLException。<br>

データ取得処理の場合↓

try {
    // データ取得処理
} catch (SQLException e) {
    // 例外処理
}

<br>

データ登録処理の例外処理

try {
    // データ更新処理
} catch (SQLException e) {
    // 例外処理
}

<br>

〜トランザクション、コミット、ロールバック〜

トランザクション…複数の処理をこれ以上分けられないように実行する仕組み。
<br>
コミット…確定処理のことで、一つのトランザクション内で発行した全てのSQLの実行を確定する処理のこと。トランザクションを使う場合、SQLを実行しただけでは結果がDBに反映されないので、全てのSQLを実行したら必ずコミットする必要がある。<br>

ロールバック…取り消し処理のことで、一つのトランザクション内で発行した全てのSQLの実行を取り消す事ができる。一つ目のSQLが成功し、2つ目のSQLが失敗してもロールバックすることによって、一つ目のSQLで実行した更新処理もなかったことに出来る。<br>

トランザクション処理の実装↓

Connection connection = null;

try {

    // コネクション取得処理
    connection = ...;   

    // 1. 自動コミットさせない設定
    connection.setAutoCommit(false);

    // ↓ユーザーAさんのお金を1,000円減らすSQLを発行

    // ↓ユーザーBさんのお金を1,000円増やすSQLを発行

    // 2. 全てのSQLが成功したので、コミット処理
    connection.commit();    

} catch (Exception e) {
    // 3. 例外が発生したのでロールバック処理
    connection.rollback();
}

<br>

1.自動コミットさせない設定…JDBCの接続設定によるが、デフォルトでは自動コミット(SQLが実行されたら即コミット)がONになっている場合に、OFFにする処理。
<br>

2.全てのSQLが成功したのでコミット処理…二つのSQLを実行して例外が発生しなかった場合、ここに到達するのでコミット処理(確定処理)を行う。<br>

3.例外が発生したのでロールバック処理…二つのSQLのどちらかが失敗、またはそれ以外の例外が発生した場合にここに到達する。成功した方のSQLも取り消さなければならないので、ロールバック処理(取り消し処理)を行う。