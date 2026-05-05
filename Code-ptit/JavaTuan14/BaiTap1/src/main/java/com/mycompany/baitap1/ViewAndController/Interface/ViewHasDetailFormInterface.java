/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.baitap1.ViewAndController.Interface;

/**
 *
 * @author azoom
 */
public interface ViewHasDetailFormInterface <T> {
    
    public void deleteFormContent();
    
    public T getFormContent();
    
    public void setFormContent(T t);
}
