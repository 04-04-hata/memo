〜カプセル化について〜

カプセル化…オブジェクトの情報をカプセルの様にまとめ、中身を隠蔽したままオブジェクトを利用する事。<br>

メソッドやフィールドの隠蔽<br>
メソッドやフィールドにアクセス修飾子を設定してアクセスを制限することで、謝って外部のプログラムが変更禁止のフィールドを変更してしまうことを防止する。<br>
一般的に、フィールドのアクセス修飾子はprivateを設定して外部から隠蔽する。<br>

getter、setter<br>
フィールドにアクセス制限をprivateにすることで、他のプログラムによる直接の変更を禁止できる様になるが、同時に値の取得も出来なくなってしまうため、フィールドの値を取得する為のgetterメソッドや値を変更するためのsetterメソッドを必要に応じて作成して、他のプログラムから参照出来るようにする。<br>
要はコヤンになんかカミングアウトしろって言っても無理やけど、太公望が道術使ってコヤンの秘密を覗き見するのはアリってことかな。<br>

getterの基本構文↓<br>
public 戻り値の型(フィールドの型) getフィールド名() {<br>
  return this.フィールド名<br>
}<br>

setterの基本構文↓<br>
public void setフィールド名(フィールドの型の引数) {<br>
  this.フィールド名 = フィールドの型の引数；<br>
}<br>