package Test1;

public class Main {
		public static void main(String args[])throws Exception{
			Lista list = new Lista();
			list.add("Bugarest");
			list.add("São Paulo");
			list.add("Cruzeiro");
			
			list.remover("São Paulo");

			list.showProximos();
			System.out.println();
			list.showAnteriores();	

			

		}
}
