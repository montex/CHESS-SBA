package org.polarsys.chess.core.internal.extensionpoint;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.resource.ResourceSet;
//import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.extensionpoint.IAddProfile;


public class AddProfileHandler {

	  private static final String ADDPROFILE_ID = 
	      "org.polarsys.chess.addprofile";
	  
	  public void executeAddProfile(IExtensionRegistry registry, Model owner, ResourceSet resourceSet) {
		  evaluateAddProfile(registry, owner, resourceSet);
	  }
	  
	  private void evaluateAddProfile(IExtensionRegistry registry, Model owner, ResourceSet resourceSet) {
	    IConfigurationElement[] config =
	        registry.getConfigurationElementsFor(ADDPROFILE_ID);
	    try {
	      for (IConfigurationElement e : config) {
	        System.out.println("Evaluating extension");
	        final Object o =
	            e.createExecutableExtension("class");
	        if (o instanceof IAddProfile) {
	        	addProfile(o, owner, resourceSet);
	        }
	      }
	    } catch (CoreException ex) {
	      System.out.println(ex.getMessage());
	      Activator.error("evaluateAddProfile error", ex);
	    }
	  }

	  private void addProfile(final Object o, final Model owner, final ResourceSet resourceSet) {
	    ISafeRunnable runnable = new ISafeRunnable() {
	      @Override
	      public void handleException(Throwable e) {
	        System.out.println("Exception in client");
	        Activator.error("Exception in client", e);
	      }

	      @Override
	      public void run() throws Exception {
	    	((IAddProfile) o).addProfile(owner, resourceSet);
	       
	      }
	    };
	    SafeRunner.run(runnable);
	  }
	  
	  public void executeLoadProfile(IExtensionRegistry registry, ResourceSet resourceSet) {
		  evaluateLoadProfile(registry, resourceSet);
	  }
	  
	  private void evaluateLoadProfile(IExtensionRegistry registry, ResourceSet resourceSet) {
	    IConfigurationElement[] config =
	        registry.getConfigurationElementsFor(ADDPROFILE_ID);
	    try {
	      for (IConfigurationElement e : config) {
	        System.out.println("Evaluating extension");
	        final Object o =
	            e.createExecutableExtension("class");
	        if (o instanceof IAddProfile) {
	        	loadProfile(o, resourceSet);
	        }
	      }
	    } catch (CoreException ex) {
	      System.out.println(ex.getMessage());
	      Activator.error("EvaluateLoadProfile error", ex);
	    }
	  }
	  
	  private void loadProfile(final Object o, final ResourceSet resourceSet) {
		    ISafeRunnable runnable = new ISafeRunnable() {
		      @Override
		      public void handleException(Throwable e) {
		        System.out.println("Exception in client");
		        Activator.error("Exception in client", e);
		      }

		      @Override
		      public void run() throws Exception {    	  
		    	  ((IAddProfile) o).loadProfile(resourceSet);
		      }
		    };
		    SafeRunner.run(runnable);
		  }
	  
	} 
	
