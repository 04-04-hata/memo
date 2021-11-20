updateアクションの定義の仕方

def update<br>
  @変数名 = モデル名.find(params[:id])<br>
  if @変数名.update(ストロングパラメーターの関数名)<br>
    redirect_to 飛ばしたいページのパス<br>
  else<br>
    render :edit<br>
  end<br>
end<br>

if @変数名.update<br>
  redirect_to 飛ばしたいページのパス<br>
else<br>
  render :edit(editアクションに飛ぶ)<br>
end<br>

これは↑if文で@変数名が更新出来た時の処理を表している。<br>

※ストロングパラメーターについてはstrongparameter.md参照<br>