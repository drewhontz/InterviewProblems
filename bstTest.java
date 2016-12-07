import java.util.Random;

public class bstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST b = new BST();
		Random rn = new Random();
		for (int i = 0; i < 10; i++){
			b.insert(rn.nextInt(20));
		}
		System.out.println("Pre order: ");
		b.preOrderTraversal(b.root);
		System.out.println("In Order:");
		b.inOrderTraversal(b.root);
		System.out.println("Post Order:");
		b.postOrderTraversal(b.root);
		System.out.println("Level Order:");
		b.levelOrderTraversal(b.root);	
	}

}
