/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.LikeDTO;

/**
 *
 * @author Sergio Barrios
 */
public class Main {
    public static void main(String[] args) {
        AmistadDAO dao= new AmistadDAO();
        System.out.println(""+dao.sigoUsuario(17,33));
    }
}
