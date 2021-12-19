〜railsの部分テンプレートでいつでも使えるerrorメッセージ〜

↓バリデーションを設定していれば全てのモデルに使用可能

<%= if model.errors.any? %>
  <div class="alert">
    <ul>
      <% model.errors.full_messages.each do |message| %>
      <li><%= message %></li>
      <% end %>
    </ul>
  </div>
<% end %>

↑layouts/_error_messages.html.erbに記述する<br>

↓エラーメッセージを表示したいページに記入 <br>

<%= render 'layouts/error_messages', model: f.object %>