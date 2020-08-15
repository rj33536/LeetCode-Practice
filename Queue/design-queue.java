class MyCircularQueue {
    int front,size,maxSize;
    int[]data;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.front = 0;
        this.size = 0;
        data = new int[k];
        this.maxSize = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.size<this.maxSize){
            int index = (front+size)%maxSize;
            data[index] = value;
            size++;
            return true;
        }
        return false;
        
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size!=0){
            size--;
            front = (front+1)%maxSize;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(size!=0){
            return data[front];
        }
        return -1;
        
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(this.size!=0){
            int index = (front+size-1)%maxSize;
            return data[index];
        }
        return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
