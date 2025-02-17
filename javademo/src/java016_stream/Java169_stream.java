package java016_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Java169_stream {

	public static void main(String[] args) {
		File file = new File("src/java016_stream/score.txt");
		RandomAccessFile raf = null;
		
		try {
			//"r" : 읽기(read)만 가능하다.
			//"rw" : 읽기(read) 쓰기(write)가 가능하다.
			raf = new RandomAccessFile(file, "r");
			
			//현재 포인터 위치값 리턴
			System.out.println(raf.getFilePointer()); //0
			System.out.println((char)raf.read()); //k
			System.out.println(raf.getFilePointer()); //1
			System.out.println(raf.readLine()); // im:56/78/12
			System.out.println(raf.getFilePointer()); //14
			System.out.println(raf.readLine()); // hong:46/100/97
			System.out.println(raf.getFilePointer()); //30
			
			//포인터의 위치를 변경한다. (파일 처음부터 포인터를 찾는다.)
			raf.seek(4); 
			System.out.println(raf.getFilePointer()); //4
			System.out.println(raf.readLine()); //56/78/12
			
			//지정된 수 만큼 byte을 건너뛴다. (현재 포인터가 있는 위치를 기준으로 건너뛴다.)
			//전단계로는 이동할 수 없다. (즉, raf.skipBytes(-2)은 적용하지 않는다.)
			raf.skipBytes(2);
			System.out.println(raf.getFilePointer()); //16
			System.out.println(raf.readLine()); //ng:46/100/97
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null)
				try {
					raf.close(); //입력 후 try & catch 소환
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}//end main()

}//end class
