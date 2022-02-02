package Model;

// 롬복으로 생성자, 게터세터
public class MemberDTO {
	String id;
	String pw;
	String nick;
	String phone;
	String birthday;
	int sex; // 0과 1의 문자로 받게됨
	
	public MemberDTO(String id, String pw, String nick, String phone, String birthday, int sex) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.phone = phone;
		this.birthday = birthday;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}
