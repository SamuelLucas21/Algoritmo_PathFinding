package Test1;

public class Main {
		public static void main(String args[])throws Exception{
		 Lista list = new Lista();
			list.add("Bugarest", 0);
			list.add("São Paulo", 0);
			list.add("Cruzeiro", 0);
			list.add("Taubaté", 0);
			list.add("Lorena", 0);
			
			list.addRandom("Guará");

			list.showProximos();



			
		}
}
