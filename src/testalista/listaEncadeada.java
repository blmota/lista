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
public class listaEncadeada {
    
    private static class No{
        final private int dado;
        private No previous;
        private No next;
        final private No nulo = null;
        
        public No(int valor){
            this.dado = valor;
        }
        
        public boolean hasNext(){
            if(this.next != null){
                return true;
            }
            return false;
        }
        
        public boolean hasPrevious(){
            if(this.previous != null){
                return true;
            }
            return false;
        }
        
        public No getNext() {
            return this.next;
        }
        
        public No getPrevious(){
            return this.previous;
        }
        
        public void setNext(No no){
            this.next = no;
        }
        
        public void setPrevious(No no){
            this.previous = no;
        }
        
        // Inseri depois do No selecionado
        public boolean insertAfter(No novo){
            No proximo = this.getNext();
            novo.setNext(proximo);
            novo.setPrevious(proximo.getPrevious());
            proximo.setPrevious(novo);
            this.setNext(novo);
            return true;
        }
        
        // Inseri antes do No selecionado
        public boolean insertBefore(No novo){
            No anterior = this.getPrevious();
            novo.setNext(anterior.getNext());
            novo.setPrevious(this.getPrevious());
            this.setPrevious(novo);
            anterior.setNext(novo);
            return true;
        }
        
        public void remove(){
            // Se tem algum No anterior ao No selecionado
            if(this.hasPrevious())
                // Aponta o No anterior para o próximo do No a ser removido
                this.previous.setNext(this.getNext()); 
            else if(this.hasNext())
                this.next.setPrevious(this.nulo);
        }
        
        public int getDado() {
            return this.dado;
        }
    }
    
    // Método iterador que será o acesso aos nós da lista
    Iterador iterador() {
        No iter = this.head;
        return new ListaIterador(iter);
    }
    
    // Método iterador que será o acesso aos nós da lista
    Iterador iterador2() {
        No iter = this.tail;
        return new ListaIterador(iter);
    }   
    
    private static class ListaIterador implements Iterador{
        No no;
        //Iterador iter;
        
        public ListaIterador(No no){
            this.no = no;
        }
        
        @Override
        public boolean hasNext() {
            return no.hasNext();
        }
        
        @Override
        public int getDado(){
            return this.no.getDado();
        }

        @Override
        public Object getNext() {
            No next = this.no.getNext();
            return new ListaIterador(next);
        }
        
        @Override
        public int getNextDado() {
            No next = this.no.getNext();
            return new ListaIterador(next).getDado();
        }

        @Override
        public void insertAfter(Object o) {
            if(no.hasNext()){
                int valor = (int) o;
                No novo = new No(valor);
                no.insertAfter(novo);
            }
//            if(no.hasNext()){
//                No proximo = no.getNext();
//                novo.setNext(proximo);
//                proximo.setPrevious(novo);
//                no.setNext(novo);
//            }            
        }

        @Override
        public void insertBefore(Object o) {
            if(no.hasPrevious()){
                int valor = (int) o;
                No novo = new No(valor);
                no.insertBefore(novo);
            }
        }

        @Override
        public void remove() {
            no.remove();
        }

        @Override
        public boolean hasPrevious() {
            return no.hasPrevious();
        }

        @Override
        public Object getPrevious() {
            No previous = this.no.getPrevious();
            return new ListaIterador(previous);
        }
        
        @Override
        public int getPreviousDado() {
            No previous = this.no.getPrevious();
            //return new ListaIterador(previous).getDado();
            return previous.getDado();
        }
        
    }

    /**
     *
     * @return
     */
    
    private No head = null;
    private No tail = null;
    
    public void append(int valor){
        // Cria novo No
        No no = new No(valor);
        // Se head for null, aponta head para novo No
        if(this.head == null){
            this.head = no;
        }
        // Se tail não for null, seta previous e next do novo No
        if(this.tail != null){
            no.setPrevious(this.tail);
            this.tail.setNext(no);
        }
        // Aponta tail para novo No
        this.tail = no;
    }
    
    // Inseri na lista de forma ordenada
    public void insert(int valor){
        No novo = new No(valor);
        if(this.head == null){
            this.head = novo;
            this.tail = novo;
        }else{
            if(this.tail != null){
                No iter = this.head;
                if(valor <= iter.getDado()){
                    novo.setNext(iter);
                    iter.setPrevious(novo);
                    this.head = novo;
                }else if(valor >= this.tail.getDado()){
                    novo.setPrevious(this.tail);
                    this.tail.setNext(novo);
                    this.tail = novo;
                }else{
                    // Varre a lista de No enquanto não for null
                    while(iter != null){
                        // Se valor for maior que o primeiro e menor que o último
                        if(iter.getDado() >= valor){
                            No anterior = iter.getPrevious();
                            novo.setNext(iter);
                            novo.setPrevious(anterior);
                            anterior.setNext(novo);
                            iter.setPrevious(novo);
                            break;
                        }
                        iter = iter.getNext();
                    }
                }
            }
        }
    }
    
    public void addFirst(int valor){
        No no = new No(valor);
        
        No first = this.head;
        first.setPrevious(no);
        no.setNext(this.head);
        this.head = no;
    }
    
    public void remove(No no){
        // Se No for igual a tail, remove o último No
        if(this.tail == no){
            No prev = no.getPrevious();
            no.remove();
            this.tail = prev;
        }
        if(this.head == no){
            No next = no.getNext();
            no.remove();
            this.head = next;
        }
    }
    
    public void lista(){
        No iter = this.head;
        // Varre a lista de No enquanto não for null
        while(iter != null){
            System.out.println(iter.getDado());
            // iter recebe o próximo No da lista
            iter = iter.getNext();
        }
    }
    
    public No getFirst(){
        return this.head;
    }
    
    public No getLast(){
        return this.tail;
    }
    
    public void printFirst(){
        System.out.println("Primeiro: " + this.getFirst().getDado());
    }
    
    public void printLast(){
        System.out.println("Último: " + this.getLast().getDado());
    }
}
