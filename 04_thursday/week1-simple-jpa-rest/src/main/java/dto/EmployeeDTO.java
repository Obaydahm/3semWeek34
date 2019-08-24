/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author Obaydah Mohamad
 */
public class EmployeeDTO {
    
    private Long id;
    private String nameDTO;
    private String addressDTO;
    
    public EmployeeDTO(Employee e){
        this.id = e.getId();
        this.nameDTO = e.getName();
        this.addressDTO = e.getAddress();
    }
}
