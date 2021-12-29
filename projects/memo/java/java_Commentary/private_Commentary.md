〜アクセス修飾子(private)について〜

private…publicなメソッドを通してしか見られない様にする為の修飾子。<br>
要は秘め事みたいなもの。秘め事は一部の奴しか知らなかったりするので。<br>
現在のクラスからだけアクセス出来る。<br>

public…誰にでも体を許す、みたいな感じ。誰にでも公開している。<br>
全てのクラスからアクセス出来る。<br>

protected…現在のクラスとサブクラスからアクセス出来る。<br>

アクセス修飾子がない場合は、現在のクラスと同じパッケージのクラスからアクセス出来る。アクセス就職誌を省略した状態を、パッケージ内部からのみ自由にアクセスアクセス出来ると言う意味でパッケージプライベートと言う。<br>

使用例<br>

Human05.java↓<br>

package classMethod.human;<br>

public class Human05 {<br>

	private String name;
    private int age;

    public Human05() {
        name = "山田";
        age = 20;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}<br>

ClassMethod05.java↓<br>

package classMethod;<br>

import classMethod.human.Human05;<br>

public class ClassMethod05 {<br>

	public static void main(String[] args) {
        Human05 yamada = new Human05();  

        //nameとageはprivateな変数なので直接参照はできない
        //System.out.print("名前は" + yamada.name + "で、年齢は" + yamada.age + "です。");

        //nameとageそれぞれの値を返すpublicなメソッドを通して参照し出力することはできる
        System.out.print("名前は" + yamada.getName() + "で、年齢は" + yamada.getAge() + "です。");
    }
}<br>
