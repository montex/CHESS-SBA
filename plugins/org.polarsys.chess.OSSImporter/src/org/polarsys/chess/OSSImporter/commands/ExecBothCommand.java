package org.polarsys.chess.OSSImporter.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;

import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.CommandBuilder;

public class ExecBothCommand extends AbstractJobCommand {

	public ExecBothCommand() {
		super("Exec both commands");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		String ID_COMMAND = "parseOSS.commands.createIBD";
		
		CommandBuilder checkContractImplementation = CommandBuilder.build(ID_COMMAND);
		checkContractImplementation.execute();
		
		ID_COMMAND = "parseOSS.commands.browse";
		checkContractImplementation = CommandBuilder.build(ID_COMMAND);
		checkContractImplementation.execute();


	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		// TODO Auto-generated method stub

	}

}
