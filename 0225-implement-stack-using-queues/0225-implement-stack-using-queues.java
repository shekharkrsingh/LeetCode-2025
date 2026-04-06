class MyStack {
    private List<Integer> list;
    private int size;

    public MyStack() {

        list = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
        list.add(x);
        size++;
    }

    public int pop() {
        int val = list.get(size - 1);
        list.remove(size - 1);
        size--;
        return val;
    }

    public int top() {
        return list.get(size - 1);
    }

    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */