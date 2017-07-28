package util;

import java.util.UUID;

public class UUID_Util {
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
