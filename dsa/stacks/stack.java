class stack{
    static final int MAX = 10000;
    int top ;
    int a[] = new int[max]; // maximum size of stack
    
    boolean isEmpty() {
        return (top < 0);
    }

    stack(){
        top = -1;
    }

    boolean push(int x ){
        if (top >= (MAX - 1)) {
            System.out.println("stack overflow");
            return false;
        }else {
            a[++top] = x;// increment the top pointer and assign it value x
            System.out.println(x + "pushed into stack");
            return true;
        }
    }

    int pop(){
        if (top < 0){
            System.out.println("stack underflow");
            return 0;
        }else {
            int x = a[top--];
            return x;
        }
    }

    int peek(){
        if (top < 0){
            System.out.println("Stack underflow");
            return 0;
        }else {
            int x = a[top];
            return x;
        }
    }
    void print(){
        for (int i = top; i > -1; i--){
            System.out.print(" " + a[i]);
        }
    }
}

// driver code 
class Main {
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + "popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elemend present in stack");
        s.print();
    }
}





