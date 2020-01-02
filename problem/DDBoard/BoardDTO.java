package problem.DDBoard;

import java.sql.Date;

public class BoardDTO {

	 private int ano; 
	 private String title; 
	 private String content; 
	 private String writer;
	 private int viewcnt;
	 private Date regdate;
	 
	 public BoardDTO() {}//기본생성자 하나 만들어야한다.

	public BoardDTO(int ano, String title, String content, String writer, int viewcnt, Date regdate) {
		super();
		this.ano = ano;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
//		return "BoardDTO [ano=" + ano + ", title=" + title + ", content=" + content + ", writer=" + writer
//				+ ", viewcnt=" + viewcnt + ", regdate=" + regdate + "]";
//	
		return  ano + "\t" +
				title + "\t" +
				content + "\t" +
				writer + "\t" + 
				viewcnt + "\t" +
				regdate;
}
	public BoardDTO(int ano, String title, String content, String writer, Date regdate) {
		super();
		this.ano = ano;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	public BoardDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardDTO(int ano, String title, String content, String writer) {
		super();
		this.ano = ano;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	 
	
	 
	
	 
	 
	 
	 
}//CLASS
