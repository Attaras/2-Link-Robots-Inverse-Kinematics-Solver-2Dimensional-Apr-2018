/*
				˄
				|			   		 R
			  y |------------------- o (Target Coordiantes (x,y)) 
				|                 ⁄  |         
				|              ⁄     |
				|           ⁄   	 |
				|        ⁄    		 |
				|     ⁄				 |
				|  ⁄				 |
				⁄--------------------------->
				    				 x
*/

public class Two_Dimensional_Two_Link_Inverse_Kinematics {

	public static void main(String[] args) {

		double Link1 = 10;  															//Length of Link 1
		double Link2 = 10;  															//Length of Link 2
		double Target_X_Coordinate = 7;     											//Target Target_X_Coordinate
		double Target_Y_Coordinate = 10;  		 					   					//Target Target_Y_Coordinate
		double R = RFinder(Target_X_Coordinate,Target_Y_Coordinate); 					//Call function that returns value of R
		double Alpha = 180 *( ( AlphaFinder(Link1,Link2,R) -  Math.PI ) / Math.PI ) ;	//Find Alpha
		double Beta2 = Beta2Finder(Target_X_Coordinate,Target_Y_Coordinate);			//Find Beta2
		double Beta1 = Beta1Finder(Link1,Link2,R);										//Find Beta1
		double Beta = 180 * ( ( Beta1 + Beta2 ) / Math.PI ) ;							//Calculate Beta

		System.out.println("Beta = " + Beta);
		System.out.println("Alpha = " + Alpha);
		
	}

	private static double Beta1Finder(double Link1, double Link2, double R) {
	/*
	  		    								 / L1^2 + R^2 - L2^2 \
			 					Beta1 =  cos^-1 ( ------------------- )
							    				 \   2 * L1 * R      /
	*/	
		double a = ( Math.pow(Link1, 2) + Math.pow(R, 2) - Math.pow(Link2, 2)  )   /    (2 * Link1 * R);
		double Beta2 = Math.acos(a);
		return Beta2;
	}

	private static Double Beta2Finder(double Target_X_Coordinate, double Target_Y_Coordinate) {
		double Beta2 = Math.atan2(Target_Y_Coordinate, Target_X_Coordinate);
		return Beta2;
	}

	private static double AlphaFinder(double Link1, double Link2, double R) {
	/*
												  / L1^2 + L2^2 - R^2 \
								 Alpha =  cos^-1 ( ------------------- )
												  \   2 * L1 * L2     /
	*/
		double a = ( Math.pow(Link1, 2) + Math.pow(Link2, 2) - Math.pow(R, 2)  )   /    (2 * Link1 * Link2);
		double Alpha = Math.acos(a);
		return Alpha;
	}

	private static double RFinder(double Target_X_Coordinate, double Target_Y_Coordinate) {
		
		// R = Sqrt(X^2 + Y^2)
		
		double R = Math.sqrt(  Math.pow(Target_X_Coordinate, 2) + Math.pow(Target_Y_Coordinate, 2)   );  //finding out Rance
		return R;
	}
	
	
	

}
