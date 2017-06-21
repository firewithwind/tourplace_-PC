package custom;

import entity.*;
public class MyStack {
	private Order top = null;
	public MyStack(){}
	public void push(){
		
	}
	public Order pull(){
		Order ret = this.top;
		if(this.top != null){
			this.top = this.top.shift;
		}
		return ret;
	}
	public void push(Order order){
		order.shift = this.top;
		this.top = order;
	}
}
