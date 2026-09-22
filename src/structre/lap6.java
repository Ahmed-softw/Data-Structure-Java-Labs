package structre;
class myAryQueue{
int front, rear , size;
double [] values ;
myAryQueue(int n){
values = new double [n] ;
front = rear = 0;
size = n ;
}
public void enqueue(double x){ // rear is pointing to next free position
if( !isFull( ) )
values[rear++] = x;
}
public double dequeue( ){
if( ! isEmpty( ) )
return values[front++];
return 0;
}
public boolean isFull(){
if((rear) == size)
return true;
return false;
}
public boolean isEmpty(){
	return (rear == front);
	}
	public double first ( ){
	if( ! isEmpty( ) )
	return values[front];
	return 0;
	}
	public void printQueue() {
	for (int i = front ; i < rear ; i++)
	System.out.print(values[i] + " ");
	}
	}
	/////////////////////////////////////////
	public class lap6 {
	public static void main(String[] args) {
	double x = 10.0;
	myAryQueue aryQueue = new myAryQueue (4);
	System.out.println("isEmpty ? " + aryQueue.isEmpty());
	System.out.println("Enqueue 4 values >0 ....");
	aryQueue.enqueue(x);
	aryQueue.enqueue(x+2);
	aryQueue.enqueue(x+4);
	aryQueue.enqueue(x+6);
	System.out.println("isFull ? " + aryQueue.isFull());
	System.out.println("\n Print the Queue :");
	aryQueue.printQueue();
	System.out.println("\n\n First = " + aryQueue.first() );
	System.out.println("\n Dequeue one value :");
	x = aryQueue.dequeue();
	System.out.println("Dequeued " + x);
	System.out.println("\n Print the Queue :");
	aryQueue.printQueue();
	}
	}
