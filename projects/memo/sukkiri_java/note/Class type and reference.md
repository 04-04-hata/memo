〜クラス型と参照〜

インスタンスの事は「操作と属性を持ち、コンピューター内の仮想世界に生み出される登場人物」という概念的な表現をしてきたが
実際は勇者やばけばけばーのような存在がコンピューターの中に住んでおり、あれこれ活躍する訳ではない。<br>
Javaの仮想世界と表現してきたものは実際にはコンピューターのメモリ領域で、この領域は、javaのプログラムを実行する際に
JVMが大量にメモリ領域(通常は数百MB〜数GB)を使って準備するもので、ヒープという。<br>
そして、私たちがnewを用いてインスタンスを生み出すたびにヒープの一部の領域(通常は数十〜数百バイト)が確保され、
インスタンスの情報を格納するために利用される。<br>
そのため、多くの属性を持った大きなクラスをインスタンス化すると、消費されるヒープ領域は必要とする容量に従って大きくなる。<br>

インスタンスとは、「ヒープの中に確保されたメモリ領域」に過ぎない<br>

クラス型変数とその内容
インスタンスが生まれる際に、コンピューターの中で何が起こっているか、以下のコード↓を例に探っていく<br>

public class Buttle {<br>
  public static void main (String args) {<br>
  // 勇者を生成<br>
    Hero h = new Hero(); // Heroクラスからインスタンスを生成し、変数hに入れる<br>
    h = new Hero();<br>
    h.hp = 100;<br>
  }<br>
}<br>

1.Hero型変数の確保<br>
最初に動くのはHero h;<br>
この行↑を実行するとJVMはHero型の変数hをメモリ内に準備する。<br>
JVMは広いヒープ領域の中から現在利用していないメモリ領域を探し出して自動的にそこを確保してくれる。<br>
1928番地が空いていたとして、ここが変数h用に確保されたとする。<br>

この段階↑ではまだ勇者自体は生まれていない。<br>
Hero型の箱が準備されるだけで、この箱には数値や文字列を入れる事は出来ないし、Hero型でないばけばけばーインスタンスを入れる事も出来ない。<br>

