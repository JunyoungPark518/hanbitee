package domain;

import handler.CommandHandler;
import lombok.*;

@Data
public class Command implements CommandHandler {
	@Getter @Setter
	private String directory, action, page;
	@Getter
	private String view;
	
	public Command(String directory, String action, String page) {
		this.directory = directory;
		this.action = action;
		this.page = page;
	}
	
	@Override
	public String process() {
		String temp = "";
		return temp;
	}
	
	public void setView(String view) {
		this.view = "/WEB-INF" + this.directory + "/" + this.page + ".jsp";
	}
}
