package org.polarsys.chess.m2m;

import org.eclipse.core.resources.IFile;

public class TransformationResultsData {
	public String res;
	public IFile umlFile;

	public TransformationResultsData(String res, IFile umlFile) {
		this.res = res;
		this.umlFile = umlFile;
	}
}