package java007_class.part06;

public class Java079_overloading {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.addValue(4, 8);
		cal.addValue(2, 7, 5);
		cal.addValue(1.0, 2.0);
		cal.addValue(1.2f, 4.5f);
		cal.addValue(1L, 2L);
	  //cal.addValue(1L);
		
	}//end main()

}//end class
