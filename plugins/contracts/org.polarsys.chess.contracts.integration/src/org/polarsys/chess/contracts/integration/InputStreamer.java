/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputStreamer extends Thread {

	private InputStream is;
	private String resultFile;
	
	InputStreamer(InputStream is, String type){
		this.is = is;
	}

	InputStreamer(InputStream is, String type, String resultFile){
		this.is = is;
		this.resultFile = resultFile;
	}

	public void run(){

		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			if(resultFile != null){
				PrintWriter writer = new PrintWriter(resultFile);
				String line=null;
				while ((line = br.readLine()) != null){
					writer.println(line);
				}
				writer.flush();
				writer.close();
			}else{
				String line=null;
				while ((line = br.readLine()) != null){
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}

}
