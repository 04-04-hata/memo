部分テンプレートとrenderの使い方

部分テンプレート…<%= render '部分テンプレートのある場所のパス', ローカル変数: インスタンス変数 %>と書く事で、<br>
複数のビューに簡単に同じ処理をさせる事ができる。<br>
部分テンプレートを保存する場合は、他のビューと区別する為に<br>
↓下記のように_を先頭につけた名前で保存する。<br>

_ビュー名.html.erb<br>

使用例<br>
gacha_kakeibosというディレクトリ内に_listindex.html.erbが
ある事とする。<br>
対応するアクション…gacha_kakeibos_controllerのindex<br>

<%= render 'gacha_kakeibos/listindex', gacha_kakeibos: @gacha_kakeibos %><br>

補足<br>
インスタンス変数は、対象のビューに対応するアクション内で使われているインスタンス変数を記述している。<br>