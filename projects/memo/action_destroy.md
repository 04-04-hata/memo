destroyアクションの定義の仕方

def destroy<br>
  @変数名 = モデル名.find(params[:id])<br>
  if @変数名.destroy
    redirect_to 飛ばしたいページのパス<br>
  else
    render :show(showアクションに飛ぶ)<br>
  end<br>
end<br>

モデル名.find(params[:id])で特定のid(カラム)のデータを探す<br>

if @変数名.destroy
    redirect_to 飛ばしたいページのパス<br>
else
    render :show(showアクションに飛ぶ)<br>
end<br>

これは↑if文で@変数名が消去出来た時の処理を表している。<br>