public class Lab02 {
    public static void main(String[] args) {

    }
}

interface List <E> {
    int size(); // Returns the size of the list
    boolean isEmpty(); // Checks whether the list is empty or not
    E first(); // returns the element/data of first entry in the list
    E last(); // returns te element/data of last entry in the list
    void addFirst(E e); // adds the given element at the start of the list
    void addLast(E e); // adds the given element at the end of the list
    E removeFirst(); // removes the first element in the list
}

interface Circlular {
    void rotate(); // tail becomes next of tail if not empty
}

interface Doubly <E> extends List <E> {
    E removeLast(); //removes the last element from the list
}

interface INode <E> { // storage unit
    E getElement(); // data/element
    Node<E> getPrev(); // returns the previous unit of this unit
    void setPrev(Node<E> prev); // sets the previous of this unit
    Node<E> getNext(); // returns the next unit of this unit
    void setNext(Node<E> next); // sets the next of this unit
}

/*
 * According to given above given interfaces, implement:
 *       1. A concrete Node class that implements INode generic interface
 *       2. A concrete SinglyLinkedList class that implements List generic interface
 *       3. A concrete CircularLinkedlist class that implements List generic interface and Circular interface
 *       4. A concrete DoublyLinkedList class that implements Doubly generic interface
 * For each of the concrete classes, use Node class as the storage unit
 * !! SinglyLinkedList class must have head and tail data fields
 * !! CircularLİnkedList class must have tail data field
 * !! Every class except Node must only have a single constructor without any parameters
 * You can implement any additional method you would like
 */

class Node<E> implements INode<E>{
    private Node<E> next;
    private Node<E> prev;
    private E element;

    Node(E e, Node<E> previous, Node<E> next){
        this.prev=previous;
        this.next=next;
        element=e;
    }
    Node(E e, Node<E> next){
        this.next=next;
        this.element=e;
    }

    @Override
    public E getElement() {
        return element;
    }

    @Override
    public Node<E> getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Node<E> prev) {
        this.prev=prev;
    }

    @Override
    public Node<E> getNext() {
        return next;
    }
    public boolean hasNext(){
        if(this.next!=null)
            return true;
        else
            return false;
    }
    @Override
    public void setNext(Node<E> next) {
        this.next=next;
    }
}
class SinglyLinkedList<E> implements List<E> {
    private Node<E> head=null;
    private Node<E> tail=null;
    SinglyLinkedList(){

    }
    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    @Override
    public int size() {
        if(head==null || tail==null){
            return 0;
        }
        else{
        int count=0;
        Node<E> temp=head;
            while(temp!=null){
                temp=temp.getNext();
                count++;
        }
        return count;
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.size()==0)
            return true;
        else
            return false;
    }

    @Override
    public E first() {
       if(isEmpty())
           return null;
       else
           return head.getElement();
    }

    @Override
    public E last() {
        if(isEmpty())
            return null;
        else
            return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode=new Node<>(e,null);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.setNext(head);
            head=newNode;
        }
    }
    @Override
    public void addLast(E e) {
        Node<E> newNode=new Node<>(e,null);
        if(tail==null){
            head=newNode;
        }
        else{
            tail.setNext(newNode);
        }
        tail=newNode;
    }

    @Override
    public E removeFirst() {
        E result;
        if(head.hasNext() && head!=null){
            result=head.getElement();
            head=head.getNext();
            return result;
        }
        else
            return null;
    }
}
class CircularLinkedList<E> implements List<E>, Circlular {
    private Node<E> tail = null;

    CircularLinkedList() {

    }

    @Override
    public int size() {
        if (tail == null)
            return 0;
        else {
            int count = 1;
            Node<E> move = tail.getNext();
            while (move != tail) {
                move = move.getNext();
                count++;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public E first() {
        return tail.getNext().getElement();
    }

    @Override
    public E last() {
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        if (tail != null) {
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        } else {
            Node<E> newNode = new Node<>(e, null);
            tail = newNode;
            tail.setNext(tail);
        }
    }

    @Override
    public void addLast(E e) {
        if(tail!=null) {
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        else{
            tail=new Node<>(e,null);
            tail.setNext(tail);
        }
    }

    @Override
    public E removeFirst() {
        if (tail == null)
            return null;
        else {
            E result;
            if (tail.getNext() == tail) {
                result = tail.getElement();
                tail = null;
            } else {
                result = tail.getNext().getElement();
                tail.setNext(tail.getNext().getNext());
            }
            return result;
        }
    }

    @Override
    public void rotate() {
        if (tail != null) {
            Node<E> temp = tail;
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            tail = temp;
        }
    }
}
class DoublyLinkedList<E> implements Doubly<E> {
    private Node<E> head;
    private Node<E> tail;

    DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, null, head);
        head.setNext(tail);
    }

    @Override
    public int size() {
        int count = 0;
        Node<E> temp = head;
        while (temp != null) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public E first() {
        if (head != null)
            return head.getElement();
        else
            return null;
    }

    @Override
    public E last() {
        if (tail != null)
            return tail.getElement();
        else
            return null;
    }

    @Override
    public void addFirst(E e) {
        Node<E> addThis = new Node<>(e, null, head);
        head.setPrev(addThis);
        head = addThis;
    }

    @Override
    public void addLast(E e) {
        if (tail == null) {
            Node<E> node = new Node<>(e, null, null);
            tail = node;
            head = node;
        } else {
            Node<E> node = new Node<>(e, tail, null);
            tail.setNext(node);
            tail = node;
        }
    }

    @Override
    public E removeFirst() {
        if (head == null)
            return null;
        E result = head.getElement();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        return result;
    }

    @Override
    public E removeLast() {
        if (tail == null)
            return null;
        E result = tail.getElement();
        if (head == tail) {
            head = null;
            tail = null;
            return result;
        }
        tail = tail.getPrev();
        tail.setNext(null);
        return result;
    }
}