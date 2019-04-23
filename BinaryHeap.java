public class BinaryHeap {
	protected int [] data;
	protected int size;


	public BinaryHeap() { //initialize the tree
		data = new int[10];
		size = 0;
	}

	public void add(int item) {
		if(size==data.length) {//grow array when it is full
			grow_array();
		}
		data[size++] = item;
		int current = size - 1;
		int parent = (current-1)/2; //find the parent of the new item
		while(data[current]<data[parent]) {//swap if the new item is samller than parent, keep looping
			swap(data,current,parent);
			current = parent;
			parent = (current-1)/2;
		}
	}

	public int remove() {
		if(size==0) {//throw error when there are nothing.
			System.out.println("error");
		}
		swap(data,0,size-1);
		size--;//delete the root
		if(size!=0) {
			shiftDown(0);//move the root to where it should be
		}
		return data[size];

	}

	public void shiftDown(int i)
	{
		int parent = i;
		int left = 2 * parent + 1;//find its left child
		int right = 2 * parent + 2;//right child

		if(left >= size || right >= size)//no child
			return;
		if(data[left] > data[right] && data[right] < data[parent])//right child is smaller than left and parent, swap it; 
		{
			swap(data, parent, right);
			shiftDown(right);
		}
		else if(data[right] > data[left] && data[left] < data[parent])//left child is smaller, swap it;
		{
			swap(data, parent, left);
			shiftDown(left);
		}

	}


	public void swap(int [] a,int x,int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public void grow_array() {
		int[] temp = new int[data.length*2];
		for(int i = 0;i<data.length;i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
}