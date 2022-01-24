〜JUnitについて〜

単体テスト…プログラムが期待通りに動作するかどうかを検証するために行う作業。
一般的にテスト対象はプログラムの中の部品(メソッド、クラスなど)単位。<br>
単体テストはテストコードとして記載し、自動で繰り返し実行出来るようにする事が多い。<br>

JUnit…JavaのテストFrameworkの一種。単体テストの実行や結果の検証などに必要な機能が揃っている。<br>

〜テストクラスのルール〜

1.テストメソッドを一つ以上含む
2.テストクラスはabstractにしない
3.テストクラスはprivateにしない

〜テストメソッドのルール〜

1.テストメソッドであることを示すorg.junit.jupiter.api.Testアノテーションをつける<br>
2.テストメソッドはabstractにしない
3.テストメソッドはprivateにしない
4.テストメソッドは戻り値を持たない(voidにする)

CalculatorTest.java

package unitTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    // org.junit.jupiter.api.DisplayNameアノテーションで、テスト結果表示画面に使う文言を設定できる
    // DisplayNameアノテーションなしの場合は、テストメソッド名が表示される
    @DisplayName("2の二乗は4になる")
    void testSquare2() {

        // 1. テスト対象クラスのセットアップとして、インスタンス化や必要に応じて初期値のセットなどを行う
        Calculator calc = new Calculator();

        // 2. テスト対象メソッド（今回はsquareメソッド）を実行し、結果を取得する
        int result = calc.square(2);

        // 3. 実行結果の実測値と期待値の検証（アサーション）を行う
        // ここでは実測値（result）が期待結果（4）と一致するかどうかを検証
        assertThat(result, is(4));
    }
}
<br>

テストメソッドの中は↓のような構成で記載する

1.テスト対象クラスのセットアップ
2.テスト対象メソッドの実行
3.実行結果の検証(アサーション)

<br>

3.の実行結果の検証の部分では、JUnitや関連ライブラリーが用意してくれている様々なメソッドを利用出来る。
assertThatメソッドはhamcrestというライブラリのもの。
hamcrestはテスト結果の検証(アサーション)に関する豊富な機能を備えている。
assertThat(result, is(4))の部分は、assert that result is 4 という風に英語の流れに近い形で読みやすい書き方ができるのが特徴。

〜例外を検証するテストの書き方〜

例:root()メソッド(引数に与えられた数値の平方根を返すメソッド。負の値を受け付けた場合はIllegalArgumentExceptionをthrowする)を追加する<br>

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("2の二乗は4になる")
    void testSquare2() {
        Calculator calc = new Calculator();
        int result = calc.square(2);
        assertThat(result, is(4));
    }

    // テストメソッド追加
    @Test
    @DisplayName("4の平方根は2になる")
    void testRoot4() {
        Calculator calc = new Calculator();
        double result = calc.root(4.0);
        assertThat(result, is(2.0));
    }

    // テストメソッド追加
    @Test
    @DisplayName("-1の平方根は例外が発生する")
    void testRootException() {
        Calculator calc = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calc.root(-1));
    }
}

<br>testRoot4()テストメソッドは、root()メソッドに対する正常系のテスト。
テストメソッドの構成はtestSquare2()テストメソッドと同様で、テスト対象クラスのセットアップ、テストの実行、実行結果の検証から成り立っている。<br>

@Test
    @DisplayName("4の平方根は2になる")
    void testRoot4() {
        // 1. テスト対象クラスのセットアップ
        Calculator calc = new Calculator();
        // 2. テスト対象メソッド（今回はrootメソッド）を実行し、結果を取得する
        double result = calc.root(4.0);
        // 3. 実行結果の実測値と期待値の検証（アサーション）
        assertThat(result, is(2.0));
    }

<br>

testRootException()テストメソッドは、例外を検査するテスト。

@Test
    @DisplayName("-1の平方根は例外が発生する")
    void testRootException() {
        // 1. テスト対象クラスのセットアップ
        Calculator calc = new Calculator();
        // 2. テスト対象メソッドの実行と、3. 実行結果の検証を1行で行う
        // org.junit.jupiter.api.Assertions.assertThrowsメソッドを使用する
        assertThrows(IllegalArgumentException.class, () -> calc.root(-1));
    }

<br>

JUnitで例外の検証を行うためには、assertThrows()メソッドを使用する。
assertThrowsメソッドの引数は2つある。

第一引数では、テストの期待結果の例外クラスを指定する。
今回は引数に-1を渡した時のテストなので、IllegalArgumentException.classが発生することを期待する。

第二引数では、テスト対象メソッドの実行をラムダ式で指定する。
ここでは() -> calc.root(-1)と指定している。<br>

今回はroot()メソッドの引数に負の値(-1)を指定した時にIllegalArgumentExceptionが期待通りにthrowされるかどうかを検証している。

〜共通処理をまとめる方法〜

class CalculatorTest {

    // テスト対象クラスをフィールドに追加
    private Calculator calc;

    // 各テストメソッドの実行前に毎回呼ばれる処理を記載する
    @BeforeEach
    void setUp() {
        // フィールドにCalculatorクラスのインスタンスをセットする
        calc = new Calculator();
    }

    @Test
    @DisplayName("2の二乗は4になる")
    void testSquare2() {
        // calcフィールドを呼び出してテスト実行する
        int result = calc.square(2);
        assertThat(result, is(4));
    }

    // ...省略...
}

まず、テストクラスにCalculatorクラスのフィールドを追加しています。これは、各テストメソッドからCalculatorクラスを参照できるようにするためです。
次に、@BeforeEachアノテーションがついたsetUp()メソッドを作成しています。@BeforeEachアノテーションとは、各テストメソッドの実行前に必ず行いたいメソッドに付与するアノテーションです。この設定によって、各テストクラスの実行前に毎回setUp()メソッドが呼ばれるようになります。
setUp()メソッドでは、各テストメソッドで行なっていたインスタンス化の処理を行い、テストクラスのフィールドにセットしています。
テストメソッド側では、事前にインスタンスがセットされたcalcフィールドを呼び出してテストを実行しています。
今回抽出したような単純な初期化処理では、共通化することのメリットが分かりにくいかもしれませんが、クラス間の依存が複雑になり初期化処理なども大量にある場合には効果を発揮します。
また、@BeforeEachアノテーション以外にも、テストメソッドの後処理（データベースへの接続のクローズなど）を共通化する場合は、@AfterEachアノテーションを使用します。

<br>

〜モックを使ったテストをする〜

モック…試作品の模型や見せかけのものといった意味の言葉。
テストの文脈では、テスト対象が依存する別の部品の代わりとして利用するものという意味。

例:Calculatorクラスを利用するクラスとして、MockitoSampleクラスを用意。

MockitoSample.java

package mockitoTest;

import unitTest.Calculator;

public class MockitoSample {

    private Calculator calc;

    public MockitoSample() {
        calc = new Calculator();
    }

    public String getSquareResult(int x) {
        int result = calc.square(x);
        return x + "の二乗の結果は" + result;
    }
}

<br>

MockitoSampleクラスでは、フィールドにCalculatorクラスを持っています。
コンストラクタでCalculatorクラスのインスタンス化を行なっています。
そしてgetSquareResult()メソッドは、引数で与えられた数値を二乗した結果を文章で返すメソッドです。
メソッドの中では、Calculatorクラスのsquare()メソッドを呼び出し、その結果を文字列に結合して返しています。

〜テストクラスの作成〜

例:利用しているCalcuatorクラスはモック化し、MockitoSampleクラスのテストクラスを作成。

MockitoSampleTest.java

package mockitoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

// 拡張機能を追加
@ExtendWith(MockitoExtension.class)
class MockitoSampleTest {

    @Test
    void test() {
        fail("まだ実装されていません");
    }
}

テストクラスに@ExtendWithアノテーションを付与しています。これは、MockitoがJUnit5に対応するための拡張機能の設定となっています。<br>

続いて、テスト対象のMockitoSampleクラスと、MockitoSampleクラスが利用するCalculatorクラスをフィールドに用意します。<br>

package mockitoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import unitTest.Calculator;

@ExtendWith(MockitoExtension.class)
class MockitoSampleTest {

    // モック化するクラスをフィールドに追加
    @Mock
    private Calculator calc;

    // テスト対象クラス（＝モックを利用するクラス）をフィールドに追加
    @InjectMocks
    private MockitoSample sample;

    @Test
    void test() {
        fail("まだ実装されていません");
    }
}

<br>

@Mockとは、モック化したいクラスのフィールドに付与するアノテーションです。今回は、Calculatorクラスのモックが自動で生成されます。Calculatorクラスのモックとは、Calculatorクラスのメソッドは持っているが中身の処理は何も実装されていない（＝メソッドを呼び出しても何も起こらない）ような挙動をするものです。<br>

@InjectMocksとは、モックを注入したいクラスのフィールドに付与するアノテーションです。つまり今回は、MockitoSampleクラスの中で使っているCalculatorクラスが、テスト用のCalculatorのモックに差し替えられて自動でセットされます。<br>

続いて、これらのモック設定に必要な初期化処理の記載を追加します。<br>

package mockitoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import unitTest.Calculator;

@ExtendWith(MockitoExtension.class)
class MockitoSampleTest {

    @Mock
    private Calculator calc;

    @InjectMocks
    private MockitoSample sample;

    // 全てのテストメソッドの前に実行されるよう設定する
    @BeforeEach
    void setUp() {
        // モック設定の初期化するメソッドを呼び出す
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test() {
        fail("まだ実装されていません");
    }
}

<br>

MockitoAnnotations.initMocks()メソッドは、アノテーションで指定したモックの設定を利用できるようにするための初期化メソッドです。
引数にはテストクラス自身を渡すため、thisを渡している。<br>

1.セットアップの部分↓

package mockitoTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import unitTest.Calculator;

@ExtendWith(MockitoExtension.class)
public class MockitoSampleTest {

    // フィールドは省略

    @Test
    // テスト結果表示用にテストメソッドの説明を記載
    @DisplayName("getSquareResultに5を渡した時に25が表示できる")
    void test() {
        // 1. テストの前準備として、モック化したクラスのセットアップを行う
        when(calc.square(5)).thenReturn(25);
    }
}

<br>

まず、テストクラスの中にテストの前準備を記載します。ここではモック化したCalculatorクラスの挙動を定義しています。
Calculatorクラスのモックは、メソッドは持っていますがその中身は何も実装されていません。そのため、何か意図した挙動をさせたい場合には、メソッドが呼び出された時の条件や結果などを定義する必要があります。
今回は「getSquareResultに5を渡した時に25が表示できる」ようなテスト内容にしたいため、それにあった設定をしていきます。<br>

when(xxx).thenReturn(yyy)の部分は、Mockitoに用意されたメソッドで、「xxxの時にyyyを返す（＝戻り値をyyyとする）」という意味になります。
英語を読む流れのようにwhen xxx then return yyyと読むことができるため、意味を捉えやすい書き方になっているのが特徴。<br>

whenの引数にはclac.square(5)と記載している。
これは、Calculatorクラスのsquare()メソッドに引数として5が渡された場合という意味。つまり、when(calc.square(5)).thenReturn(25);という記載は、Calculatorクラスのsquare()メソッドに引数として5が渡された場合、戻り値として25を返すという意味になる。<br>

なおこの場合、引数に5が与えられた時の挙動しか定義していないため、calc.square(4) やcalc.square(15)といった場合には何も返さない。<br>

2.テストの実行の部分↓

package mockitoTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import unitTest.Calculator;

@ExtendWith(MockitoExtension.class)
public class MockitoSampleTest {

    // フィールドは省略

    @Test
    @DisplayName("getSquareResultに5を渡した時に25が表示できる")
    void test() {
        when(calc.square(5)).thenReturn(25);

        // 2. テスト対象メソッド（今回はgetSquareResultメソッド）を実行し、結果を取得する
        String result = sample.getSquareResult(5);
    }
}

<br>

今回はgetSquareResult()メソッドを実行し、結果を取得しています。
getSquareResult()メソッドの引数には5を渡しています。
こうすることで、getSquareResult()メソッドの中からモック化されたCalculatorクラスのsquare()メソッドが呼び出され、square()メソッドは定義された通りに25を返します。
その戻り値を使って、getSquareResult()メソッドの処理が実行され、最終的に文字列が返ってきます。<br>

3.実行結果の検証↓

package mockitoTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import unitTest.Calculator;

@ExtendWith(MockitoExtension.class)
public class MockitoSampleTest {

    // フィールドは省略

    @Test
    @DisplayName("getSquareResultに5を渡した時に25が表示できる")
    void test() {
        when(calc.square(5)).thenReturn(25);
        String result = sample.getSquareResult(5);

        // 3. 実行結果の実測値と期待値の検証（アサーション）を行う
        assertThat(result, is("5の二乗の結果は25"));
    }
}

<br>

assertThat()の部分では、Calculatorクラスのモックから返ってきた値の25を使って期待通りに文字列の結合ができているかどうかを検証しています。