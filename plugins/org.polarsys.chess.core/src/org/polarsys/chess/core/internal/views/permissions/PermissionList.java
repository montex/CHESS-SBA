/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2016                             --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Authors: Alessandro Zovi          azovi@math.unipd.it             --
--          Laura Baracchi           laura.baracchi@intecs.it        --
--          Stefano Puri             stefano.puri@intecs.it          --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.internal.views.permissions;

import java.util.ArrayList;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.core.util.CHESSProjectSupport;

/**
 * @author Alessandro Zovi
 */
public class PermissionList extends ArrayList<PermissionEntry> {

//	ArrayList<PermissionEntry> mArray = new ArrayList<PermissionEntry>();
//	
//	public void addEntry(PermissionEntry e){
//		mArray.add(e);
//	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6775060867788553534L;

	public PermissionList getEntry(Element el, Stereotype str, Feature feature) {
		EntryId id = EntryId.generateEntryId(el, str, feature);
		
		return getEntry(id);
	}
	
	public PermissionList getEntry(EntryId id) {
		PermissionList l = new PermissionList();
		for (PermissionEntry pe : this) {
			if (pe.match(id) != null)
				l.add(pe);
		}
		return l;
	}
	
	
	
	public boolean checkPermission(EntryId id, byte permission){
		PermissionList l = getEntry(id);
		//if two permissions refer to the same element, pick the less conservative:
		//allow to overwrite permissions with the result of the merge of two permissions (OR)
		l = merge(l);
		//if there are no matches return false, the element is not writable 
		if (l.isEmpty()){
			return false;
		}
		//else pick the most conservative result (if one of the matches is false then the result must be false)
		for (PermissionEntry pe : l) {
			if (!pe.checkPermission(permission)) {
				CHESSProjectSupport.printlnToCHESSConsole(id + " " + PermissionEntry.getPermissionType(permission) + " <=> " + pe.getId());
				return false; 
			}
		}
		return true;
	}
	
	private PermissionList merge(PermissionList list){
		if (list.size()==1)
			return list;
		
		for (int i = 0; i < list.size(); i++) {
			PermissionEntry pei = list.get(i);
			for (int j = i+1; j < list.size(); j++) {
				PermissionEntry pej = list.get(j);
				if (pei.getId().equals(pej.getId())&&
						pei.getDomain().equals(pej.getDomain())){
					CHESSProjectSupport.printlnToCHESSConsole(pei.getId() + "||"+ pej.getId());
					list.remove(j--);
					PermissionEntry pe = new PermissionEntry(pei.getId(), 
							pei.isOwner() || pej.isOwner(), 
							pei.isWriteable() || pej.isWriteable(), 
							pei.isVisible() || pej.isVisible(),
							pei.getDomain());
					pei = pe;
					list.set(i, pe);
				}
			}
		}
		return list;
	}

}

