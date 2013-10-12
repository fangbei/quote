package com.gildata.quote.client;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class QuoteUtils {
	
	public static void writeString(ByteBuf byteBuf,String str, int length, Charset charset){
		if (str != null) {
			byte[] b = str.getBytes(charset);
			int len = b.length;
			if (len > length) {
				byteBuf.writeBytes(b, 0, length);
			} else {
				byteBuf.writeBytes(b);
				if (len < length) {
					byteBuf.writeZero(length - len);
				}
			}
		} else {
			byteBuf.writeZero(length);
		}
	}
	
	public static void writeEncodable(ByteBuf byteBuf,Encodable encodable, int length){
		if (encodable == null){
			byteBuf.writeZero(length);
		}else{
			encodable.encodeAsByteBuf(byteBuf);
		}
		
	}

}