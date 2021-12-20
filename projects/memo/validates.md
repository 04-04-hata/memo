バリデーションについて

バリデーション…railsでDBに保存する時に制限をかける事。<br>
様々な種類がある。<br>

〜バリデーションの仕方〜<br>

models/モデル名.rbで↓以下のように記載する<br>

validates :カラム名, 制約ルール<br>

使用例:フォームの入力時に空白を許さない場合<br>

validates :カラム名, presence:true

※presenceとは、空白を許さない事。これをtrueにする事で
フォームが空白の時はDBの保存に待ったをかけられる。