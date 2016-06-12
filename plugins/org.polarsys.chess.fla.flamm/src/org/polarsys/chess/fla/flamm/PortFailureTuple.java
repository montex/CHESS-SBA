/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.flamm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class PortFailureTuple {
	Port port;
	Failure failure;
	
	PortFailureTuple(Port port, Failure failureType) {
		this.port = port;
		this.failure = failureType;
	}
	
	static List<PortFailureTuple> fromMap(Map<Port, Failure> map) {
		List<PortFailureTuple> list = new ArrayList<PortFailureTuple>(map.size());
		for (Port port : map.keySet()) {
			list.add(new PortFailureTuple(port, map.get(port)));
		}
		return list;
	}
	
	static Set<PortFailureTuple> fromCollection(Port port, Collection<Failure> failures) {
		Set<PortFailureTuple> set = new HashSet<PortFailureTuple>(failures.size());
		for (Failure failure : failures) {
			set.add(new PortFailureTuple(port, failure));
		}
		return set;
	}

	public Port getPort() {
		return port;
	}

	public Failure getFailure() {
		return failure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((failure == null) ? 0 : failure.getId().hashCode());
		result = prime * result + ((port == null) ? 0 : port.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PortFailureTuple other = (PortFailureTuple) obj;
		if (failure == null) {
			if (other.failure != null) {
				return false;
			}
		} else if (!failure.getId().equals(other.failure.getId())) {
			return false;
		}
		if (port == null) {
			if (other.port != null) {
				return false;
			}
		} else if (!port.equals(other.port)) {
			return false;
		}
		return true;
	}
	
	
}