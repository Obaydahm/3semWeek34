/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Obaydah Mohamad
 */
@Entity
public class Animal1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private int birthYear;
    private String sound;

    public Animal1 (){}
    
    public Animal1(String type, int birthYear, String sound) {
        this.type = type;
        this.birthYear = birthYear;
        this.sound = sound;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getType() {
        return type;
    }
    
    public int getBirthYear() {
        return birthYear;
    }

    public String getSound() {
        return sound;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    
}
