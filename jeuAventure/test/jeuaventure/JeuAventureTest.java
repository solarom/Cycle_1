/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeuaventure;

import org.junit.Test;  
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Araik
 */
public class JeuAventureTest {
    @Test

    public void test_jeuAventure_saisirNombre() {       
       assertTrue(JeuAventure.jeuAventure_saisirNombre() >= 0);
       assertTrue(JeuAventure.jeuAventure_saisirNombre() <= 100);
       assertFalse(JeuAventure.jeuAventure_saisirNombre() < 0);
       assertFalse(JeuAventure.jeuAventure_saisirNombre() > 100);
    }
    
    public void test_jeuSuite_formeCorrecte() {
        assertEquals('t', JeuAventure.jeuSuite_formeCorrecte(1));
        assertEquals('c', JeuAventure.jeuSuite_formeCorrecte(2));
        assertEquals('c', JeuAventure.jeuSuite_formeCorrecte(3));
    }
}
