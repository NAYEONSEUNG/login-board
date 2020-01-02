package problem.DDEnter;

import java.sql.Date;

public class MemberDTO {
	// DTO 기본문법.
	// 1.변수(DB Table참조)
	private String ano;   //널로 초기화
	private String aname;	//널로초기화
	private String major;
	private String groupyn;
	private String groupnm;
	private int sal;  //0으로 초기화
	private Date regdate;

	// 2.생성자(Default , 전역변수 ALL )
	public MemberDTO() {

	}

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal, Date regdate) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
		this.regdate = regdate;
	}
	
	//우리가 원하는 다섯개만 담는 가방 생성
	public MemberDTO(String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.aname = aname;//위의 매개변수들이 온다. / 디스는 클래스가 아니고 인스턴스 나 자신
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}
	
	
//여섯개 가방
	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}

	// 3.getter(), setter() //7개변수의 겟터 셋터 메서드
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGroupyn() {
		return groupyn;
	}

	public void setGroupyn(String groupyn) {
		this.groupyn = groupyn;
	}

	public String getGroupnm() {
		return groupnm;
	}

	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	//4.tostring()

	@Override
	public String toString() {// 투스트링 메서드 만들었다. 
		return ano + "\t "+ aname + "\t"+ major +"\t " + groupnm+"\t"
				+  sal+"\t" +regdate;
	}
	
	
	
	
}// class
