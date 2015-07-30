/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.internal.views.permissions;


/**
 * @author Alessandro Zovi
 */
public class PermissionEntry {
	public static final byte WRITABLE = 0;
	public static final byte OWNER = 1;
	public static final byte VISIBLE = 2;
	
	public static String OWNER_ATR = "owner", VISIBLE_ATR = "visible", WRITE_ATR = "write";
	private EntryId id;
	private boolean owner;
	private boolean visible;
	private boolean write;
	
	public EntryId getId() {
		return id;
	}

	public boolean checkPermission(byte permission){
		if(permission == OWNER)
			return owner;
		if(permission == WRITABLE)
			return write;
		if(permission == VISIBLE)
			return visible;
		return false;
	}
	
	public boolean isOwner() {
		return owner;
	}

	public boolean isWriteable() {
		return write;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public PermissionEntry(EntryId id, boolean owner, boolean write, boolean visible) {
		this.id = id;
		this.owner = owner;
		this.write = write;
		this.visible = visible;
	}
	
	public PermissionEntry match(EntryId id){
		if (this.id.match(id))
			return this;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer(30);
		s.append(id.toString());
		s.append('|');
		
		s.append(owner? 'o' : '-');
		s.append(write? "rw" : "r-");
		s.append(visible? 'v' : '-');
		return s.toString();
	}
	
	public static String getPermissionType(byte permission) {
		switch (permission) {
		case OWNER:
			return "OWNER";
		case VISIBLE:
			return "VISIBLE";
		case WRITABLE:
			return "WRITE";
		default:
			return "";
		}
	}
}
