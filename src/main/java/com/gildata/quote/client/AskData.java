package com.gildata.quote.client;

import java.util.Arrays;

import io.netty.buffer.ByteBuf;

public class AskData extends Envelope {


	private CodeInfo[] codes;
	
	public AskData(EnvelopeType type) {
		super(type);
	}

	public AskData(EnvelopeType type, CodeInfo[] codes) {
		super(type);
		this.codes = codes;
	}


	public CodeInfo[] getCodes() {
		return codes;
	}

	public void setCodes(CodeInfo[] codes) {
		this.codes = codes;
	}

	@Override
	public void encodeBody(ByteBuf byteBuf) {
		if (codes != null) {
			byteBuf.writeShort(codes.length);
			byteBuf.writeShort(0);
			for (CodeInfo c : codes) {
				c.encodeAsByteBuf(byteBuf);
			}

		}
	}

	@Override
	public int getBodyLength() {
		int len = 0;
		if (codes != null) {
			len = 4 + 8 * codes.length;
		}
		return len;
	}

	@Override
	public String toString() {
		return "AskData [codes=" + Arrays.toString(codes) + ", type=" + type
				+ "]";
	}
	
	

}
