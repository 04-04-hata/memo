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
※ストロングパラメーターについてはstrongparameter.md参照<br>

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

