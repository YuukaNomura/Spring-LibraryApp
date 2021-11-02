package kakeibo.entity;

public class User {

	/** ユーザID */
	private String id;

	/** 名前 */
	private String name;

	/** パスワード */
	private String pass;

	/** 引数なしコンストラクタ 　*/
	public User(){

	}

	/**
	 *  情報設定コンストラクタ
	 *
	 * 	@param id タイトル
	 *  @param pass 著者
	 *  @param name 出版社
	 */
	public User(String id, String pass, String name){
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	/**
	 * ユーザID取得
	 * @return ユーザID
	 */
	public String getId() {
		return id;
	}

	/**
	 * ユーザID設定
	 * @param id ユーザID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 名前取得
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前設定
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * パスワード取得
	 * @return パスワード
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * パスワード設定
	 * @param pass パスワード
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * 文字列化
	 * @return 文字列
	 */
	@Override
	public String toString() {
		return "User[userId : " + this.id + ", pass : " + this.pass + ", userName : " + this.name + "]";
	}	
}
