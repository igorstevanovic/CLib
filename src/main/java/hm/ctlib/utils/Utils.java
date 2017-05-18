package hm.ctlib.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public String EncryptPassword(String inputPassword) throws Exception {
		String encryptedPassword = null;
		encryptedPassword = new BCryptPasswordEncoder().encode(inputPassword);

		return encryptedPassword;
	}

}
