import java.util.LinkedList;

public class GraphNode {
	String name;
	GraphNode[] adj;
	boolean marked;
	
	public GraphNode(String d){
		this.name = d;
		this.marked = false;
	}
	
	public void setAdjacent(GraphNode[] n){
		this.adj = n;
	}
	
	public boolean isThereARouteFunc(GraphNode a){
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		this.marked = true;
		q.add(this);
		
		while(!q.isEmpty()){
			GraphNode c = q.removeFirst();
			for (GraphNode gn : c.adj){
				if (gn.marked == false){
					gn.marked = true;
					q.add(gn);
				}
				if (gn.name.equals(a.name)) return true;
			}
		}
		return false;
	}
}
