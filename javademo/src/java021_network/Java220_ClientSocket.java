package java021_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//https://lktprogrammer.tistory.com/62

/*
 * Socket
 */

public class Java220_ClientSocket {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			//3 서버연결 요청       ("서버 주소", 7777)
			socket = new Socket("127.0.0.1", 7777);
			
			//4 입출력스트림 연결
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(os);
			
			InputStream is = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			
			//5 서버에 메세지를 보냄
			ow.write("클라이언트의 정보를 보냄");
			ow.flush();
			ow.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}//end main()

}//end class
