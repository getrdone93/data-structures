package list;

public class Playground {
    
    private static final int NUM_ITERS = 10000;
    
    public static void main(String args[]) {
        list.LinkedList<Integer> list = new LinkedList<>();
        java.util.LinkedList<Integer> javaList = new java.util.LinkedList<Integer>();
        
        final long startJava = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERS; i++) {
            javaList.addLast(i);
        }
        final long endJava = System.currentTimeMillis();
        
        final long start = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERS; i++) {
            list.add(i);
        }
        final long end = System.currentTimeMillis();
        
        System.out.printf("mine: %d, java: %d", end - start, endJava - startJava);
    }
    
}
