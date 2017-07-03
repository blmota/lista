/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalista;

/**
 *
 * @author particular
 */
public interface Iterador {
    boolean hasNext();
    Object getNext();
    public int getNextDado();
    int getDado();
    void insertAfter(Object o);
    void insertBefore(Object o);
    void remove();
    // A partir daqui, é opcional!
    boolean hasPrevious();
    Object getPrevious();
    public int getPreviousDado();
}
