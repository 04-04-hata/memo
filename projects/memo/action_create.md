createアクションの定義の仕方

createアクションは実際にデータを作成する為のアクション。<br>
以下のように定義する事で新規登録が出来るようになる。<br>

例<br>
def create<br>
  @変数名 = モデル名.new(ストロングパラメーターの関数名)<br>
    @変数名.ユーザーのid = current_user.id(現在のユーザーのid)<br>
    if @変数名.save<br>
        redirect_to 飛ばしたいページのパス<br>
    else<br>
      render :new(newアクションに飛ぶ)<br>
    end<br>
end<br>

〜解説〜<br>

@変数名 = モデル名.new(ストロングパラメーターの関数名)<br>
ここで↑フォームに入力されたデータの保存準備をしておく<br>
※ストロングパラメーターについては後に解説<br>

@変数名.ユーザーのid = current_user.id(現在のユーザーのid)<br>

@変数名の中に入っているユーザーのidと現在のユーザーのidが同じかを確認している。<br>
current_userはdeviseを使っている時のみに使えるヘルパーメソッドである。<br>
※devise…railsで使える新規登録・ログイン機能の為のgem。<br>

if @変数名.save<br>
  redirect_to 飛ばしたいページのパス<br>
else<br>
  render :new(newアクションに飛ぶ)<br>
end<br>

これは↑if文で@変数名が保存出来た時の処理を表している。<br>

〜ストロングパラメーターについて〜

ストロングパラメーターはデータの漏洩を防ぐ為に存在し、<br>
ストロングパラメーターに書かれていないカラムはフォームでのデータの送信を許可されない。<br>

例<br>

private<br>

  def 関数名<br>
    params.require(:モデル名).permit(:カラム名,…)<br>
  end<br>

ストロングパラメーターは必ずprivateの下に書き、<br>
privateはコントローラー内の一番最後に書く。

