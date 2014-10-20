package org.chess.statebased;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.eclipse.core.runtime.IProgressMonitor;

public class DEEMClient {

	private final static int BUFLENGTH = 1024;
	protected final static String HOST = "rclserver.dsi.unifi.it";
	protected final static int PORT = 5903;
	protected final static int TIMEOUT = 60;
	
	//private final String MODEL = "clientfiles/model";
	private final String RESULTS_SAVEAS = "analysis-results";
	private IProgressMonitor mon;

	public String sendAndReceiveFile(String model, String folder, IProgressMonitor monitor) throws UnknownHostException, SocketTimeoutException, IOException, ClassNotFoundException {

		String host = Activator.getDefault().getPreferenceStore().getString("HOST");
		int port = Activator.getDefault().getPreferenceStore().getInt("PORT");
		int timeout = Activator.getDefault().getPreferenceStore().getInt("TIMEOUT")*1000;
		System.out.println("connecting to: " + host+":"+port);

		Socket s = new Socket();
		s.connect(new InetSocketAddress(host, port), timeout);

		FileInputStream fis = new FileInputStream(model);
		OutputStream out = s.getOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(out);
		System.out.println("sending data...");
		byte[] buf = new byte[BUFLENGTH];
		int read = 0;
		while ((read = fis.read(buf)) != -1) {
			oout.write(buf, 0, read);
		}
		System.out.println("file sent");
		monitor.worked(1);

		oout.writeObject(getParameters());
		System.out.println("parameters sent");

		s.shutdownOutput();

		InputStream is = s.getInputStream();

		ObjectInputStream ois = new ObjectInputStream(is);
		boolean bRunning = true;
		DEEMProgressInformation progress = new DEEMProgressInformation();
		bRunning = ois.readBoolean();
		int lastCurrent = 0;
		String taskName;
		while(bRunning) {
			progress = (DEEMProgressInformation)ois.readObject();
			System.out.println(progress.getCurrent());

			taskName = "Simulation started: " + progress.getCurrent() + " / " + progress.getMaximum() + " (";
			if(progress.minimumReached()) {
				taskName += progress.getPercentToMax("%.2f") + "% of maximum batches)";
			}else{
				taskName += progress.getPercentToMin("%.2f") + "% of minimum batches)";
			}
			mon.subTask(taskName);
			mon.worked(progress.getCurrent()-lastCurrent);

			lastCurrent = progress.getCurrent();
			bRunning = ois.readBoolean();
		}			

		System.out.println("receiving data...");
		String res = folder + File.separator + RESULTS_SAVEAS;
		FileOutputStream fos = new FileOutputStream(res);
		buf = new byte[BUFLENGTH];
		read = 0;
		while ((read = ois.read(buf)) != -1) {
			fos.write(buf, 0, read);
		}
		System.out.println("file received");
		monitor.worked(1);

		fis.close();
		oout.close();
		out.close();
		fos.close();
		is.close();
		s.close();
		return res;	
	}
	
	protected static ParameterList getParameters() {
		ParameterList p = new ParameterList();
		
		p.setMinimumBatches(Activator.getDefault().getPreferenceStore().getInt("MINBATCHES"));
		p.setMaximumBatches(Activator.getDefault().getPreferenceStore().getInt("MAXBATCHES"));
		p.setConfidenceInterval(Activator.getDefault().getPreferenceStore().getDouble("CONFINTERVAL"));
		p.setConfidenceLevel(Activator.getDefault().getPreferenceStore().getDouble("CONFLEVEL"));
		p.setDisplayUpdateInterval(Activator.getDefault().getPreferenceStore().getInt("DISPUPDATE"));
		p.setMeasureUpdateInterval(Activator.getDefault().getPreferenceStore().getInt("MEASUPDATE"));
		p.setSeed(Activator.getDefault().getPreferenceStore().getInt("SEED"));
				
		return p;
	}
	
	protected void setProgressMonitor(IProgressMonitor monitor) {
		mon = monitor;
	}

}