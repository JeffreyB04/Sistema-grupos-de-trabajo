/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto01prograiv.presentation.login;

import com.mycompany.proyecto01prograiv.logic.Estudiante;

public class Model {
    Estudiante current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Estudiante());        
    }
    
    public Estudiante getCurrent() {
        return current;
    }

    public void setCurrent(Estudiante current) {
        this.current = current;
    }
}
