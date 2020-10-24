public class LinkedList {

    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }



    //Adds an item to linked list
    static public void push(int new_data)
    {
        // Put in the data, Set next as null
        Node new_node = new Node(new_data);

        // If the Linked List is empty, then make the new node as head
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        // Else traverse till the last node
        Node last = head;
        while (last.next != null)
            last = last.next;

        // Change the next of last node
        last.next = new_node;
        return;
    }

    static public Node detectLoop(Node h)
    {

        Node temp=h;
        //returns a node if cycle detects ,returns null otherwise
        Node p = findWhereNodesMeeting(temp);

        //iterates till pointer meets and returns start node of cycle
        if(p != null)
        {
            Node q = head;
            while(p != q)
            {
                p = p.next;
                q = q.next;
            }
            return p;
        }

        return p;
    }

    static public Node findWhereNodesMeeting(Node head)
    {
        Node p = head;
        Node q = head;
        //loop iterates until end of linked list

        while(p != null && q != null && q.next != null)
        {
            p = p.next;
            q = q.next.next;
            //if condition executes returns p
            if(p == q)
            {

                return p;
            }
        }
        //return null if there is p and q doesnt meet
        return null;
    }
    static public int findIndex()
    {
        Node CycleNode=detectLoop(head);
        //detecting index of Node
        Node temp=head;
        int index=-1;
        //if condition executes finds index if detectLoop(head) returns a node
        if(CycleNode!=null)
        {
            while(temp!=null)
            {
                index+=1;
                if(temp.data==CycleNode.data)//if index found while loop breaks
                    break;
                temp=temp.next;
            }
        }
        //returns index as -1 if no loop detected
        return index;

    }

    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        //adding items to linked list
        llist.push(3);
        llist.push(2);
        llist.push(0);
        llist.push(-4);


        //loop for testing
        llist.head.next.next.next.next= llist.head.next;
        int index=findIndex();
        System.out.println(index);
    }

}