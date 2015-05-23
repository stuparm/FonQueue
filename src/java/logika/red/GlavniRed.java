/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika.red;

import izuzetak.PrazanRedException;
import java.util.ArrayList;
import java.util.List;
import logika.domen.Student;

/**
 *
 * @author Mihailo
 */
public class GlavniRed {
    
    private List<Student> lista;
    private int redniBroj;
    
    public GlavniRed() {
        lista = new ArrayList<>();
        redniBroj = 0;
    }
    
    /**
     * Ubacuje studenta na kraj reda<br/>
     * Setuje mu redni broj.
     * @param student 
     */
    public synchronized void ubaci(Student student) {
        redniBroj++;
        student.setRedniBroj(redniBroj);
        lista.add(student);
    }
    
    /**
     * Izabacuje studenta sa pocetka reda<br/>
     * @return 
     */
    public synchronized Student izbaci() throws PrazanRedException {
        try {
            return lista.remove(0);
        } catch (Exception e) {
            throw new PrazanRedException();
        }
    }

    /**
     * Vraca studenta sa pocetka reda, ali ne izbacuje ga<br/>
     * @return 
     */
    public synchronized Student vratiPrvog() throws PrazanRedException {
        try {
            return lista.get(0);
        } catch (Exception e) {
            throw new PrazanRedException();
        }
    }
    
    
}
