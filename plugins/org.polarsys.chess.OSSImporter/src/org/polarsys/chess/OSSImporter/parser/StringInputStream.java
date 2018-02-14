package org.polarsys.chess.OSSImporter.parser;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Dennis H�bner - Initial contribution and API
 * @author Jan Koehnlein
 */
public class StringInputStream extends ByteArrayInputStream {

	public StringInputStream(String string) {
		super(string.getBytes());
	}
	
	public StringInputStream(String content, String encoding) throws UnsupportedEncodingException {
		super(content.getBytes(encoding));
	}

}
