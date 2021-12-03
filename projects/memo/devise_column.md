deviseでカラムを追加した時にするべき事

deviseはメールアドレスとパスワードで認証をするが、<br>
それを名前での認証など、認証項目を追加することが出来る。<br>

使用例<br>
今回は名前(カラム名:name)を追加する事にする。<br>

1.マイグレーションファイルに↓以下のようにカラムを追加し、<br>
rails db:migrate する<br>

t.string :name<br>

2.application_controller.rbに↓以下のように記述する<br>

before_action :configure_permitted_parameters, if: :devise_controller?<br>

  protected<br>

  def configure_permitted_parameters<br>
    devise_parameter_sanitizer.permit(:sign_up, keys: %i[name email encrypted_password])<br>
  end<br>

※:sign_up…新規登録<br>

keys: の所は、↓以下のように認証に必要なカラムを随時書いていく<br>

keys: [:name], [:email], [:encrypted_password]<br>

補足:before_action :configure_permitted_parameters, if: :devise_controller?<br>

before_action…先に指定された行為を実行する。<br>
今回の場合は、configure_permitted_parameters を実行する<br>

protected<br>

  def configure_permitted_parameters<br>
    devise_parameter_sanitizer.permit(:sign_up, keys: %i[name email encrypted_password])<br>
  end<br>

protectedの後に↑上記を記述しておく事で、<br>
セキュリティー対策にもなり、カラムの認証も出来るようになる<br>

〜ログイン時に別のカラムで認証する場合〜<br>

config/initializer/devise.rbに↓以下の内容を記述<br>

config.authentication_keys = [:カラム名]<br>

例:config.authentication_keys = [:name]<br>

↑これは、nameカラムを認証したいカラムとしている。