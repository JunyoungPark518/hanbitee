package factory;

import command.Command;
import command.ListCommand;
import command.MoveCommand;

public class CommandFactory {
	public static Command createCommand(String directory, String action, String page) {
		Command cmd = new MoveCommand(directory, action, page);
		return cmd;
	}
	
	public static Command createCommand(String directory, String action, String page, String pageNo) {
		Command cmd = null;
		switch (action) {
		case "list":
			cmd = new ListCommand(directory, action, page, pageNo);
			break;
		}
		return cmd;
	}
}
