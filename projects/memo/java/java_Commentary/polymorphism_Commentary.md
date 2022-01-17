〜ポリモーフィズムについて〜

ポリモーフィズム…同じクラス(スーバークラス)を継承した別々のクラス(サブクラス)のオブジェクトの同じメソッドを呼び出した時に、それぞれのオブジェクトの振る舞い(処理)を変える事。インターフェースを実装したクラスのオブジェクトの場合でもポリモーフィズムと言う。意味は多様性。<br>

オーバーライド…スーパークラスのメソッドをサブクラス上で上書きして再定義する事。インターフェースに定義したメソッドを実装した場合も同じようにオーバーライドと言う。<br>
オーバーライドするメソッド(サブクラス側)とオーバーライドされるメソッド(スーパークラス側)は以下の条件↓を全て満たす必要がある。<br>

- メソッド名が同じ
- 引数の方と数が同じ
- 戻り値の方が同じか、スーパークラス・サブクラスの関係にある
- 例外の型が同じか、スーパークラス・サブクラスの関係にある
- アクセス修飾子が同じか、スーパークラスの制約の方が厳しい

サブクラス側のメソッドの直前の行に@Overrideと書く事で上記の条件↑を
全て満たしていることをコンパイル時に保証できる。これを書いておくことによって1つでも欠けている条件があるとコンパイルエラーとなる。<br>

// スーパークラス
public class SuperClass {
    void overrideMethod() {
        // スーパークラスの処理
    }
}<br>

// サブクラス
class SubClass extends SuperClass {
    // スーパークラスのメソッドをオーバーライド
    @Override
    void overrideMethod() {
        // サブクラスの処理
    }
}<br>

オーバーライドもポリモーフィズムの一種で、デフォルトメソッドをそのまま呼び出すことも出来るし、処理を変えることも出来る。<br>

〜final修飾子が指定されたメソッド〜

final修飾子が指定されたメソッドはオーバーライドが禁止になる。<br>

public class Student extends Human {
    // オーバーライド禁止のため、コンパイルエラー
    public String getName() {
        return "名前は" + this.name + "です。";
    }
}


〜オーバーロードについて〜

オーバーロード…引数の型、数、並び順のいずれかが異なる同じ名前のメソッドを一つのクラスに複数定義する事。同じ処理のメソッドを同じメソッド名で定義出来る為、ソースコードが分かりやすくできる。<br>