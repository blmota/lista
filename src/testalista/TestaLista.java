/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalista;

/**
 *
 * @author 691200318
 */
public class TestaLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listaEncadeada lista = new listaEncadeada();
        
        // Inseri na sequencia dos appends
        lista.append(2);
        lista.append(3);
        lista.append(4);
        lista.append(5);
        lista.append(6);
        // Inseri no início da lista
        lista.addFirst(1);
        // Inseri de forma ordenada na lista
        lista.insert(9);
        lista.insert(7);
        lista.insert(0);
        lista.insert(20);
        lista.insert(15);
        lista.insert(13);
        lista.insert(12);
        lista.insert(11);
        lista.insert(8);
        lista.insert(10);
        lista.insert(19);
        lista.insert(14);
        
        
        // imprime os dados da lista
        imprime(lista);
        
        // Associa iterador a lista
        Iterador iter = lista.iterador();
        // Coloca o iterador apontado pro terceiro No
        for (int i = 0; i < 3; i++){
            iter = (Iterador) iter.getNext();
        }
        // Inseri antes do No apontado pelo iterador
        iter.insertBefore(99999999);
        // Inseri depois do No apontado pelo iterador
        iter.insertAfter(88888888);
        // imprime os dados da lista
        imprime(lista);
        // Imprime lista de trás pra frente
        imprime2(lista);
        
        //lista.lista();
    }
    
    // Imprime lista do primeiro ao último
    private static void imprime(listaEncadeada lista) {
        Iterador iter = lista.iterador();
        while (iter.hasNext()) {
            System.out.println(iter.getDado());
            
            if(iter.hasNext())
                iter = (Iterador) iter.getNext();
        }
        lista.printLast();
        System.out.println("---------");
    }
    // Imprime lista do último ao primeiro
    private static void imprime2(listaEncadeada lista) {
        Iterador iter = lista.iterador2();
        while (iter.hasPrevious()) {
            System.out.println(iter.getDado());
            if(iter.hasPrevious())
                iter = (Iterador) iter.getPrevious();
        }
        lista.printFirst();
        System.out.println("---------");
    }

    public static void print(String i){
        System.out.println(i);
    }
}
