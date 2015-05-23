/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika.red;

import java.util.ArrayList;
import java.util.List;
import logika.domen.Student;
import org.codehaus.jettison.json.JSONArray;
import util.properties.AppProperties;

/**
 *
 * @author Mihailo
 */
public class PomocniRed {
    
    private Student[] niz;
    private int index;
    
    public PomocniRed() {
        niz = new Student[AppProperties.getInstance().getKapacitetPomocniRed()];
        index = 0;
    }
    
    /**
     * Ubacuje ga na kraj niza<br/>
     * kad se popuni kapacitet niza krece se opet od pocetka
     * @param student 
     */
    public synchronized void ubaci(Student student) {
        niz[index = (++index%niz.length)] = student;
    }
    
    private synchronized List<Student> sviStudenti() {
        List<Student> lista = new ArrayList<>();
        int tekuci = index;
        for (int i = 0; i < niz.length; i++) {
            if (niz[tekuci] != null)
                lista.add(niz[tekuci]);
        }
        return lista;
    }
    
    public JSONArray sviStudentiJSONArray() {
        List<Student> lista = sviStudenti();
        JSONArray jsonArray = new JSONArray();
        for (Student student : lista) {
            jsonArray.put(student.getJSON());
        }
        return jsonArray;
    }
    
    
    
    
    
}
