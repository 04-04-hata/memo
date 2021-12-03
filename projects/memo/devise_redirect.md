deviseでログイン、ログアウト後のリダイレクト先の変更の仕方

app/controllers/application_controller.rbに記述。<br>
ログイン、ログアウト共にリダイレクト先はデフォルトでトップページである為、ログインやログアウト後のリダイレクト先がトップページである場合、記述しなくてもいい。<br>

サインイン後のリダイレクト先の変更<br>

def after_sign_in_path_for(resource)<br>
  リダイレクトしたいパス<br>
end

サインアウト後のリダイレクト先の変更<br>

def after_sign_out_path_for(resource)<br>
  root_path<br>
end<br>

↑上記の場合はルートパスに移動する。<br>
