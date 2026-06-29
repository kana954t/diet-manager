# Diet Manager（ダイエット管理アプリ）

## 概要

Diet Managerは、日々の体重・BMI・食事・運動内容を記録できるダイエット管理Webアプリです。

職業訓練で学習したJava、Servlet/JSP、MySQLを活用し、授業で制作した「どこつぶ」の構成を参考にして制作します。  
ユーザーごとにダイエット記録を管理し、日々の体重変化や目標体重との差を確認できるアプリを目指します。

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
## 画面遷移図

```mermaid
flowchart TD
    Start["アプリ起動"]
    Login["ログイン画面"]
    Register["ユーザー登録画面"]
    Home["ホーム画面"]
    RecordForm["記録登録画面"]
    RecordList["記録一覧画面"]
    Goal["目標体重設定画面"]
    Logout["ログアウト"]

    Start --> Login
    Login -->|ログイン成功| Home
    Login -->|新規登録| Register
    Register -->|登録完了| Login

    Home --> RecordForm
    Home --> RecordList
    Home --> Goal
    Home --> Logout

    RecordForm -->|登録完了| RecordList
    RecordList -->|戻る| Home
    Goal -->|設定完了| Home
    Logout --> Login
```
## DB設計

### usersテーブル

| カラム名 | 型 | 内容 |
| --- | --- | --- |
| id | INT | ユーザーID |
| name | VARCHAR(50) | ユーザー名 |
| password | VARCHAR(255) | パスワード |
| created_at | DATETIME | 登録日時 |

### diet_recordsテーブル

| カラム名 | 型 | 内容 |
| --- | --- | --- |
| id | INT | 記録ID |
| user_id | INT | ユーザーID |
| record_date | DATE | 記録日 |
| weight | DECIMAL(5,2) | 体重 |
| bmi | DECIMAL(4,1) | BMI |
| breakfast | VARCHAR(255) | 朝食 |
| lunch | VARCHAR(255) | 昼食 |
| dinner | VARCHAR(255) | 夕食 |
| exercise | VARCHAR(255) | 運動内容 |
| memo | TEXT | メモ |
| created_at | DATETIME | 登録日時 |

## 機能

- ユーザー登録
- ログイン / ログアウト
- 体重登録
- 体重履歴表示
- BMI計算
- 目標体重管理
- 進捗確認
- ユーザーごとの記録管理
'''

## 使用技術

- Java
- Servlet / JSP
- MySQL
- JDBC
- HTML / CSS
- Eclipse
- Git / GitHub

## 工夫した点

- Servlet、JSP、Logic、DAOに役割を分け、処理の流れをわかりやすくします。
- 体重データをMySQLに保存し、履歴として確認できるようにします。
- ログイン中のユーザー情報を使い、自分の記録だけを表示できるようにします。
- BMI計算や目標体重との差分を表示し、進捗を確認しやすくします。

## 今後の改善

- 記録の編集機能
- グラフ表示機能の追加
- 入力チェックの強化
- 画面デザインの改善
