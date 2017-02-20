package domain;


import lombok.*;

@Data
public class ArticleBean{
	@Getter @Setter
	private String seq, id, title, content, regdate, readCount;
	@Override
	public String toString() {
		return String.format("[%s | %s | %s | %s | %s]\n", seq, id, title, regdate, "0");
	}
}
