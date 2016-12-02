package day1;

import java.util.Scanner;

public class Start {
	public static void main(String[] args){
		/* north 0
		 * east 1
		 * soth 2
		 * west 3
		 */
		int direction = 0;
		int[] steps = new int[4];
		steps[0] = 0;
		steps[1] = 0;
		steps[2] = 0;
		steps[3] = 0;
		System.out.println("hej");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		input.replaceAll(" ", "");
		String[] arguments = input.split(",");
	
		for(String s: arguments){
			s = s.trim();
			String d = s.substring(0, 0);
			System.out.println(s);
			int step = Integer.parseInt(s.substring(1));
			if(d.equalsIgnoreCase("R")){
				direction = (direction + 1) % 4;
			}
			else{
				if(direction == 0){
					direction = 3;
				}
				else{
					direction -= 1;
				}
			}
			steps[direction] += step;
			System.out.println(steps[0]-steps[2]);
			System.out.println(steps[1]- steps[3]);
		}
		System.out.println(Math.abs(steps[0]-steps[2]) + Math.abs(steps[1]- steps[3]));
		

	}
}
