/*
 * Este es mi código para el examen de listas enlazadas.
 * Voy a usar algunos dígitos de mi DNI: 2787991320101.
 *
 * Operaciones que se hacen:
 * 1. Agrego el primer dígito (2) al inicio.
 * 2. Agrego el segundo dígito (7) al final.
 * 3. Agrego el tercer dígito (8) en la posición 1 (en medio).
 * 4. Imprimo la lista.
 * 5. Remuevo el cuarto dígito (7).
 * 6. Imprimo la lista.
 * 7. Agrego el quinto dígito (9) al final.
 * 8. Verifico si la lista contiene el sexto dígito (9) (debe dar true).
 * 9. Verifico si la lista contiene el séptimo dígito (1) (debe dar false).
 * 10. Revierto la lista.
 * 11. Imprimo la lista.
 * 12. Agrego el octavo dígito (3) al inicio.
 * 13. Imprimo la lista final.
 */

// Clase para representar cada nodo de la lista
class Node {
    int data;   // Aquí se guarda el número
    Node next;  // Puntero al siguiente nodo
    // Constructor: le asignamos el valor y el next empieza como null
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// Clase para la lista enlazada
class LinkedList {
    private Node head;  // Este es el primer nodo de la lista; si es null, la lista está vacía
    // Constructor: crea una lista vacía
    public LinkedList() {
        this.head = null;
    }

    // Método para agregar un nodo al final de la lista
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // Si no hay nada en la lista, el nuevo nodo se vuelve head
            head = newNode;
            return;
        }
        Node current = head;
        // Recorro la lista hasta llegar al final (donde current.next es null)
        while (current.next != null) {
            current = current.next;
        }
        // Agrego el nuevo nodo al final
        current.next = newNode;
    }

    // Método para agregar un nodo al inicio de la lista
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // El nuevo nodo apunta al antiguo head
        head = newNode;       // Ahora el nuevo nodo es el head
    }

    // Método para insertar un nodo en una posición específica
    public void addMiddle(int data, int position) {
        // Si la posición es 0 o la lista está vacía, agregamos al inicio
        if (position <= 0 || head == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int count = 0;
        // Avanzo hasta justo antes de la posición donde quiero insertar
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        // Si llegué al final, lo agrego al final
        if (current == null) {
            add(data);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

     // Método para remover el primer nodo que tenga el valor indicado
    public void remove(int data) {
        if (head == null) return;  // Si la lista está vacía, no hago nada

        // Si el head es el que se tiene que remover
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        // Recorro la lista hasta encontrar el nodo antes del que quiero eliminar
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        // Si encuentro el nodo, lo remuevo saltándolo
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
     // Método para imprimir la lista
    public void printList() {
        Node current = head;
        // Recorro todos los nodos e imprimo su valor
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Método para invertir la lista
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        // Voy cambiando los enlaces para invertir el orden
        while (current != null) {
            next = current.next;   // Guardo el siguiente nodo
            current.next = prev;   // Hago que el nodo actual apunte al anterior
            prev = current;        // Muevo prev al nodo actual
            current = next;        // Paso al siguiente nodo
        }
        head = prev;  // Al final, prev es el nuevo head
    }

    // Método para ver si la lista contiene un valor
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
// Clase principal donde ejecuto todo lo que se pide
public class Main {
    public static void main(String[] args) {
        // Voy a usar estos dígitos de mi DNI: 2787991320101
        // d1 = 2, d2 = 7, d3 = 8, d4 = 7, d5 = 9, d6 = 9, d7 = 1, d8 = 3
        LinkedList lista = new LinkedList();
        // 1. Agrego d1 (2) al inicio.
        lista.addFirst(2);
        
        // 2. Agrego d2 (7) al final.
        lista.add(7);
        
        // 3. Agrego d3 (8) en la posición 1 (en medio).
        lista.addMiddle(8, 1);
        
        // 4. Imprimo la lista actual.
        System.out.println("Lista actual:");
        lista.printList();
        
        // 5. Remuevo d4 (7) de la lista.
        lista.remove(7);
        
        // 6. Imprimo la lista después de remover el 7.
        System.out.println("Lista después de remover 7:");
        lista.printList();
        
        // 7. Agrego d5 (9) al final.
        lista.add(9);
        
        // 8. Chequeo si la lista contiene d6 (9), debería dar true.
        System.out.println("¿Contiene 9? " + lista.contains(9));
        
        // 9. Chequeo si la lista contiene d7 (1), debería dar false.
        System.out.println("¿Contiene 1? " + lista.contains(1));
        
        // 10. Revierto la lista.
        lista.reverse();
        
        // 11. Imprimo la lista después de revertir.
        System.out.println("Lista después de revertir:");
        lista.printList();
        
        // 12. Agrego d8 (3) al inicio.
        lista.addFirst(3);
        
        // 13. Imprimo la lista final.
        System.out.println("Lista final:");
        lista.printList();
    }
}
