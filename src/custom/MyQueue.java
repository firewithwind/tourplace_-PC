package custom;
import entity.*;

public class MyQueue {
	private Scenic top = null;
	private Scenic end = null;
	public MyQueue(){}
	public void offer(Scenic scenic){
		if(this.end != null){
			this.end.next = scenic;
			this.end = this.end.next;
		}else{
			this.top = scenic;
			this.end = scenic;
		}
	}
	public Scenic poll(){
		Scenic ret = this.top;
		if(ret != null){
			this.top = this.top.next;
		}
		return ret;
	}
}
