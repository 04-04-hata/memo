〜JDBC(DB接続) データ抽出〜

JDBC…Java Database Connectivityの略で、Javaで様々なデータベースに接続する方法を提供するAPI(アプリケーションプログラミングインターフェースの略。何かしらの機能をアプリケーションから簡単に呼び出せるようにした仕様の事。)<br>

JCDCドライバ…JDBC APIの実装を各データベースごとに用意しているもの。
ほとんどの場合、JAR(Java ARchive)のファイル形式で配布されており、Javaの実行時にクラスパスに追加することによってデータベース操作を実行出来る。<br>

JDBC API…Javaからデータベースを操作するための標準的なAPI仕様であり、接続先のデータベースごとの差異を吸収するもの。<br>

代表的なDBのJDBCドライバ
- Oracle
- MySQL
- PostgreSQL

Docker…仮想化技術を使ったソフトウェアの一つで、仮想環境にOSをインストールしなくても様々なソフトウェアを利用出来る。<br>

〜DB接続〜(DockerとKitematicの設定が終わっている前提とする。)

JDBCドライバを使えるようにする(※↓の行は必ず必要)

Class.forName(“com.mysql.cj.jdbc.Driver”);

↑Class.forNameにJDBCドライバのクラス名を渡してクラスを取得している。
<br>

何が行われているか、com.mysql.cj.jdbc.Driverのソースをみてみましょう。<br>

//com.mysql.cj.jdbc.Driver<br>
static {
    try {
        java.sql.DriverManager.registerDriver(new Driver());
    } catch (SQLException E) {
        throw new RuntimeException("Can't register driver!");
    }
}<br>
DriverManagerに自分自身を登録しています。<br>Class.forNameを実行することによって、com.mysql.cj.jdbc.Driverのstaticブロックが実行され、ドライバが使えるようになるわけです。<br>
次に、接続（java.sql.Connection）を作ります。<br>
Connectionを作るには、接続URLが必要です。
MySQLの場合は、以下のようになります。<br>
jdbc:mysql://ホスト名:ポート番号/データベース名?user=ユーザー名&password=パスワード&useSSL=false
何が行われているか、com.mysql.cj.jdbc.Driverのソースをみてみましょう。
//com.mysql.cj.jdbc.Driver
static {
    try {
        java.sql.DriverManager.registerDriver(new Driver());
    } catch (SQLException E) {
        throw new RuntimeException("Can't register driver!");
    }
}
DriverManagerに自分自身を登録しています。<br>Class.forNameを実行することによって、com.mysql.cj.jdbc.Driverのstaticブロックが実行され、ドライバが使えるようになるわけです。<br>
次に、接続（java.sql.Connection）を作ります。<br>
Connectionを作るには、接続URLが必要です。
MySQLの場合は、以下のようになる↓<br>
“jdbc:mysql://ホスト名:ポート番号/データベース名?user=ユーザー名&password=パスワード&useSSL=false”
<br>useSSL=falseは接続にSSLを使わないという意味。MySQL5.7からデフォルトではSSL接続を要求されるようになったが、ローカルでの検証ではfalseにしておく。<br>

このURL文字列を使って、Connectionを作る↓
String url = “jdbc:mysql://ホスト名:ポート番号/データベース名?user=ユーザー名&password=パスワード&useSSL=false”
Connection connection = DriverManager.getConnection(url);
例外が発生することなくConnectionが生成出来たら成功。<br>

〜データの抽出〜

データの抽出にはSQLを発行する事が必要になるが、JDBCでSQLを発行する時は
java.sql.PreparedStatementクラスを使う↓<br>

PreparedStatement statement = connection.prepareStatement(“データ抽出条件”);

次に、このPreparedStatementを実装し、実行結果を取得する。実行結果はJava.sql.ResultSetクラスで受け取る↓<br>

ResultSet resultSet = statement.executeQuery();

<br>

varchar型のカラムの値を取り出すには、(resultSet.getString(“カラム名”));
int型のカラムの値を取り出すには、(resultSet.getLong(“カラム名”));
Date型のカラムの値を取り出すには、(resultSet.getDate(“カラム名”));

ResultSetには、実行したSQLの結果が全て入っている。1行ずつ全てのデータを取り出すには、resultSet.next()を使って↓のようにループさせながら取り出す。<br>

while (resultSet.next()) {
    System.out.println("----------------------");
    System.out.println(resultSet.getLong("id"));
    System.out.println(resultSet.getString("email"));
    System.out.println(resultSet.getString("name"));
    System.out.println(resultSet.getDate("created_at"));
    System.out.println(resultSet.getDate("updated_at"));
}

<br>

〜Connection、PreparedStatement,ResultSetのclose〜

Connection(DB接続)、PreparedStatement(実行するSQL)、ResultSet(実行結果)は、それぞれ使った後にclose(閉じる)必要がある。

Java7から導入されたtry-with-resources構文を使うと自動的にclose()が呼ばれるので、宣言時に↓のように書くと、closeを呼ぶ必要はない。<br>

//Connectionの例
String url = “jdbc:mysql://ホスト名:ポート番号/データベース名?user=ユーザー名&password=パスワード&useSSL=false”
try (Connection connection = DriverManager.getConnection(url)) {

}

// PreparedStatement、ResultSetの例↓
try (PreparedStatement statement = connection.prepareStatement(“抽出条件”)) {
	try (ResultSet resultSet = statement.executeQuery()) {
	}
}

<br>
ここまでの処理のまとめ↓

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectSample {

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://ホスト名:ポート番号/データベース名?user=ユーザー名&password=パスワード&useSSL=false;

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            // com.mysql.cj.jdbc.Driverクラスをロードして、初期化処理を行う
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            // ドライバのクラスがクラスパスに見つからなかった場合にClassNotFoundExceptionが発生します。
            e.printStackTrace();
            // ドライバが見つからない場合は、後続の処理を続行できませんので、例外をthrowして処理を中断します。
            throw e;
        }

        // Connection（データベースとの接続を表す）、PreparedStatement（発行するSQLを表す）を、それぞれ生成します。
        try (Connection connection = DriverManager.getConnection(URL);
                PreparedStatement statement = connection.prepareStatement(“抽出条件”)) {

            // StatementにSQLを文字列で与えて実行します。
            // 戻り値は、SQLの実行結果を表す、ResultSet（結果セット）です。
            try (ResultSet resultSet = statement.executeQuery()) {

                // SQLの実行結果を、行数ぶんだけループしながら表示しています。
                while (resultSet.next()) {
                    System.out.println("----------------------");
                    System.out.println(resultSet.getLong(“カラム名”));
                    System.out.println(resultSet.getString(“カラム名”));
                    System.out.println(resultSet.getString(“カラム名”));
                    System.out.println(resultSet.getDate(“カラム名”));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

<br>〜パラメーター付きSQLの発行〜

PreparedStatement statement = connection.prepareStatement("select * from テーブル名 where カラム名 = ?")

<br>
where カラム名 = ?(パラメーターの部分を?で表記。この?をプレースホルダと言い、後ほどパラメーターを受け取る入れ物になる。)<br>

パラメーターのないクエリの発行→statement.executeQuery()
(例)パラメーターのあるクエリの発行→statement.setLong(1,1L);

例ではwhere id = 1を求めることとする。<br>

例のテーブルのカラムidは、データベースのint型(長さ11)なので、JavaではLong型になる。setLongでLong型のパラメーターを渡す。varchar型の場合はsetStringを使う。<br>

setLongの第一引数は例のSQL select * from user where id = ? の中の?が登場する順番を指定する。この例では?は1番目なので、1を引数に指定する。<br>

第二引数はSQLに埋め込むパラメーターそのものを指定する。この例ではwhere id = 1となるようにしたいのでLong型(long型)で、1Lを指定する。<br>

これで実行時にselect * from user where id = ?が、
select * from user where id = 1に変換される。

String型のパラメータを渡したい時も、select * from user where name = ‘山田太郎’ のようなSQLをselect * from user where name = ?のように?で置き換え、
statement.setString(1,”山田太郎”);とすることでパラメーターを渡せる。