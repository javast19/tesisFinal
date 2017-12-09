/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustalUDC.persistencia;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Home
 */
public class JTableCustom extends DefaultTableModel{
    @Override
public boolean isCellEditable(int row, int col) {
     switch (col) {
         case 8:
         case 9:
         case 10:
             return true;
         default:
             return false;
      }
}
}
