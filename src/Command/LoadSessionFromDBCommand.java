package Command;

import java.util.List;

import Model.GameSession;
import Model.Model;
import view.View;

public class LoadSessionFromDBCommand extends Command {
	
	private Model model;
	private View view;

	public  LoadSessionFromDBCommand(Model model,View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void execute() {
		
			@SuppressWarnings("unchecked")
			List<GameSession> list = model.loadSessionFromDB();
			if(list != null)
				view.displaySessionsList(list);

	}

}
