/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjava.beans;

/**
 *
 * @author prog110519
 */
public class Customer {
    private Integer id;
    private String lastName;
    private String name;
    private String mail;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(Integer id, String lastName, String name, String mail, String phoneNumber) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", lastName=" + lastName + ", name=" + name + ", mail=" + mail + ", phoneNumber=" + phoneNumber + '}';
    }
}
