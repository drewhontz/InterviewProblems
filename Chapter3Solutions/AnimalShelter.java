import java.util.Iterator;
import java.util.LinkedList;

public class AnimalShelter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Animal deQueueAny(LinkedList<Animal> l){
		return l.removeFirst();
	}
	
	public static void deQueueSpecific(LinkedList<Animal> l, String type){
		if (type != "cat" || type!="dog") throw new UnsupportedOperationException();
		if (l.getFirst().getData().equals(type)){
			l.removeFirst();
		} else {
			Iterator<Animal> itr = l.listIterator();
			while (itr.hasNext()){
				String typeOfAnimal = itr.next().data;
				if (typeOfAnimal.equals(type)) itr.remove();
			}
		}
	}
	
	public void enQueue(Animal a){}
	
	public class Animal extends Node{	
		public Animal(String s){
			this.data = s.toLowerCase();
		}
	};

}
