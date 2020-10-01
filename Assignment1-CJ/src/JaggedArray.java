
public class JaggedArray {

	public static void main(String[] args) {
		int [][] JaggedArray = new int[3][];
		
		for(int i[] : JaggedArray)
		{
			for(int j : i)
			{
				System.out.println(i + " " +j);
			}
		}

	}

}
