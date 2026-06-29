# Diet Manager（ダイエット管理アプリ）

## 概要
## アーキテクチャ図

```mermaid
flowchart TD
    User["ユーザー"]
    Browser["ブラウザ"]
    JSP["JSP<br>画面表示"]
    Servlet["Servlet<br>リクエスト処理"]
    Logic["Logic<br>入力チェック・BMI計算"]
    DAO["DAO<br>データベース操作"]
    DB[("MySQL<br>users / diet_records")]

    User --> Browser
    Browser --> JSP
    JSP --> Servlet
    Servlet --> Logic
    Logic --> DAO
    DAO --> DB
    DB --> DAO
    DAO --> Logic
    Logic --> Servlet
    Servlet --> JSP
    JSP --> Browser
```
```mermaid
flowchart TD
    Browser["ブラウザ"]

    LoginJsp["login.jsp"]
    MainJsp["main.jsp"]
    RecordJsp["record.jsp"]
    ListJsp["recordList.jsp"]

    LoginServlet["LoginServlet"]
    LogoutServlet["LogoutServlet"]
    RecordServlet["RecordServlet"]
    DeleteServlet["DeleteRecordServlet"]

    LoginLogic["LoginLogic"]
    RecordLogic["RecordLogic"]

    UserDAO["UserDAO"]
    DietRecordDAO["DietRecordDAO"]

    UserBean["User"]
    DietRecordBean["DietRecord"]

    MySQL[("MySQL")]

    Browser --> LoginJsp
    Browser --> MainJsp
    Browser --> RecordJsp
    Browser --> ListJsp

    LoginJsp --> LoginServlet
    LoginServlet --> LoginLogic
    LoginLogic --> UserDAO
    UserDAO --> MySQL

    RecordJsp --> RecordServlet
    RecordServlet --> RecordLogic
    RecordLogic --> DietRecordDAO
    DietRecordDAO --> MySQL

    ListJsp --> RecordServlet
    DeleteServlet --> DietRecordDAO

    UserBean --> UserDAO
    DietRecordBean --> DietRecordDAO
```

Javaで作成した体重管理アプリです。
日々の体重とBMIを記録し、ダイエットの進捗を可視化することを目的としています。

## 機能

* 体重登録
* 体重履歴表示
* BMI計算
* 目標体重管理
* 進捗確認

## 使用技術

* Java
* Eclipse
* Git / GitHub

## 工夫した点

* クラスを分けて設計し、拡張しやすい構造にしました
* 体重データを履歴として管理できるようにしました

## 今後の改善

* データベース連携（MySQL）
* GUI化（Swing）
* グラフ表示機能の追加
