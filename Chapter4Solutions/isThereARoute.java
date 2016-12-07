public class isThereARoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphNode a,b,c,d,e;
		a = new GraphNode("A");
		b = new GraphNode("B");
		c = new GraphNode("C"); 
		d = new GraphNode("D");
		e = new GraphNode("E");
		
		
		GraphNode[] aa = {d};
		a.setAdjacent(aa);
		
		GraphNode[] ba = {a};
		b.setAdjacent(ba);
		
		GraphNode[] ca = {d, e};
		c.setAdjacent(ca);
		
		GraphNode[] da = {};
		d.setAdjacent(da);
		
		GraphNode[] ea = {a,b,d};
		e.setAdjacent(ea);

		
		System.out.println(a.isThereARouteFunc(d));
		System.out.println(a.isThereARouteFunc(b));
		System.out.println(c.isThereARouteFunc(a));
	}
}
