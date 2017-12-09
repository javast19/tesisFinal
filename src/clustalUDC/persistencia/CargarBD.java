
package clustalUDC.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class CargarBD {
    private List cellData;
    public CargarBD(File fileName, String codon, String mutacion){
        List cellData = new ArrayList();
        try{
            //Un FileInputStream obtiene bytes de entrada desde un archivo en
            //un sistema de archivos.
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            //XSSFSheet son las estructuras centrales dentro de un libro, y son
            //donde un usuario hace la mayor parte de su obra hoja de calculo.
            
            //Obten hoja con el nombre dado (mayusculas y minusculas partido)
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            
            //RowIterator es un iterador, una coleccion de filas y columnas
            Iterator rowIterator = hssfSheet.rowIterator();
            int sum=0;
            //Nos movemos por los registros
            //hasNext devuelve true si la iteracion tiene mas elementos
            while(rowIterator.hasNext()){
                //La representacion de alto nivel de una hoja de calculo
                //Obtenemos los datos de las celdas de la fila.
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                
                //Almacenamos los datos en el Iterator
                Iterator iterator = hssfRow.cellIterator();
                List cellTemp = new ArrayList();
                //Nos movemos por los datos de cada fila o sea las celdas
                while (iterator.hasNext()){
                    //almacenamos los datos de las celdas en hssfCell
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    //y luego esos los almacenamos en cellTemp
                    cellTemp.add(hssfCell);
                    
                }
                //cuales filas guardar
                if(cellTemp.get(3).toString().equals(codon) && cellTemp.get(5).toString().equals(mutacion))
                //if(cellTemp.get(3).toString().equals(codon))
                cellData.add(cellTemp);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        //List fCellData = obtenerFila(cellData);
        //imprimir(cellData);
        this.cellData = cellData;
        
    }
    
//    private void imprimir(List cellDataList){
//        for (int i = 0; i < cellDataList.size(); i++) {
//            List cellTempList = (List) cellDataList.get(i);
//            for (int j = 0; j < cellTempList.size(); j++) {
//                //cuales columnas imprimir
//                if ((j>=1 && j<=7) || (j == 22) || (j == 23) || (j == 37)){
//                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
//                String stringCellValue = hssfCell.toString();
//                System.out.print(stringCellValue+" ");
//                }
//            }
//            System.out.println();
//            
//        }
//    }

    /**
     * @return the cellData
     */
    public List getCellData() {
        return cellData;
    }

    /**
     * @param cellData the cellData to set
     */
    public void setCellData(List cellData) {
        this.cellData = cellData;
    }
    
}
