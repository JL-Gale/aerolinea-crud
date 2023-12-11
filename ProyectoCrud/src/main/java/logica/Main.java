
package logica;

import javax.swing.JOptionPane;
import persistencia.ControladoraPersistencia;

public class Main {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlpersi = new ControladoraPersistencia();
        
        int opcionMenu, numeroAsientos, asientoAEeliminar = 0, buscar, confimacion = 0;
        boolean aux1 = true, aux2 = true, aux3 = true;
        String nombreYapellidos[] = new String[183];
        String nacionalidad[] = new String[183];
        int edad[] = new int[183];
        long numeroDeDocumento[] = new long[183];
        long numeroDeTelefono[] = new long[183];
        String mostrar;
        
        while (aux1 == true) {
          
            mostrar = "Asientos disponibles";
            numeroAsientos = 0;
            for (int i = 0; i < 183; i++) {
                if (i%20==0) {
                    mostrar += "\n";
                }
                if (nombreYapellidos[i] == null) {
                    numeroAsientos++;
                    mostrar += i+1;
                    mostrar += "  ";
                }
            }
            
            if (numeroAsientos < 183) {
                aux2 = true;
            } else {
                aux2 = false;
            }
            
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog("Aerolínea vuelos sin límite.com."+
                    "\nVuelo V578 \n"+ mostrar +
                    "\nNumero de asientos: "+numeroAsientos+
                    "\n\nIngresar la opcion"+
                    "\n1. Nuevo pasajero"+
                    "\n2. Buscar pasajero"+
                    "\n3. Mostrar datos de los pasajeros"+
                    "\n4. Eliminar pasajero"+
                    "\n5. Cerrar programa"));
            switch (opcionMenu) {
                case 1:
                    
                    int asientoPasajero = Integer.parseInt(JOptionPane.showInputDialog(mostrar+"\n\nElija el asiento del pasajero"));
                    asientoPasajero--;
                    
                    
                    for (int i = asientoPasajero; i < asientoPasajero+1; i++) {
                           
                           nombreYapellidos[i] = JOptionPane.showInputDialog("Nombres y apellidos");
                           if (nombreYapellidos[i] == null) {
                            break;
                        }
                           nacionalidad[i] = JOptionPane.showInputDialog("Nacionalidad");
                           edad[i] = Integer.parseInt(JOptionPane.showInputDialog( "Edad"));
                           numeroDeDocumento[i] = Long.parseLong(JOptionPane.showInputDialog( "Numero de documento"));
                           numeroDeTelefono[i] = Long.parseLong(JOptionPane.showInputDialog("Numero de telefono"));
                    }
                    
                    
                    
                    do {                        
                        confimacion = JOptionPane.showConfirmDialog(null, "La informacion del pasajero esta correcta?"+
                                    "\nNumero de asiento: "+(asientoPasajero+1)+
                                    "\nNombres y apellidos:  "+nombreYapellidos[asientoPasajero]+
                                    "\nNacionalidad:  "+nacionalidad[asientoPasajero]+
                                    "\nEdad:  "+edad[asientoPasajero]+
                                    "\nNumero de identificacion:  "+numeroDeDocumento[asientoPasajero]+
                                    "\nNumero de telefono:  "+numeroDeTelefono[asientoPasajero], 
                                    "",JOptionPane.YES_NO_OPTION, 
                                    JOptionPane.INFORMATION_MESSAGE);
                        
                        if (confimacion == 1) {
                        for (int i = asientoPasajero; i < asientoPasajero+1; i++) {
                           JOptionPane.showMessageDialog(null, "Por favor vuelva a llenar los datos");
                           nombreYapellidos[i] = JOptionPane.showInputDialog("Nombres y apellidos");
                           nacionalidad[i] = JOptionPane.showInputDialog("Nacionalidad");
                           edad[i] = Integer.parseInt(JOptionPane.showInputDialog( "Edad"));
                           numeroDeDocumento[i] = Long.parseLong(JOptionPane.showInputDialog( "Numero de documento"));
                           numeroDeTelefono[i] = Long.parseLong(JOptionPane.showInputDialog("Numero de telefono"));
                         }
                    }
                        JOptionPane.showMessageDialog(null, "Datos guardados");
                    } while (confimacion == 1);
                    
                    break;
                case 2:
                    if (aux2 == true) {
                        buscar = Integer.parseInt(JOptionPane.showInputDialog( "La busqueda solo se puede hacer mediante el numero de documento"+
                            "\nIngrese el numero de documento"));
                    for (int i = 0; i < 183; i++) {
                        
                        if (numeroDeDocumento[i] == buscar) {
                            aux3 = false;
                            JOptionPane.showMessageDialog(null, "Datos encontrados"+
                                    "\nNumero de asiento: "+(i+1)+
                                    "\nNombres y apellidos:  "+nombreYapellidos[i]+
                                    "\nNacionalidad:  "+nacionalidad[i]+
                                    "\nEdad:  "+edad[i]+
                                    "\nNumero de identificacion:  "+numeroDeDocumento[i]+
                                    "\nNumero de telefono:  "+numeroDeTelefono[i]);
                        } 
                      }
                        if (aux3 == true){
                            JOptionPane.showMessageDialog(null, "No se encontro ningun dato que coinsidad");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Todavia no hay pasajeros");
                    }
                    
                    break;
                case 3:
                    if (aux2 == true) {
                        mostrar  = "Asiento N°        \n";
                    for (int i = 0; i < 183; i++) {
     
                        if (nombreYapellidos[i] != null) {
                                      
                        mostrar += "         ";
                        mostrar += (i+1);
                        mostrar += "       ";
                        mostrar += "Nombres y apellidos:  "+nombreYapellidos[i];
                        mostrar += "      ";
                        mostrar += "Nacionalidad:  "+nacionalidad[i];
                        mostrar += "      ";
                        mostrar += "Edad:  "+edad[i];
                        mostrar += "      "; 
                        mostrar += "Numero de documentos:  "+numeroDeDocumento[i];
                        mostrar += "      ";
                        mostrar += "Numero de telefono:  "+numeroDeTelefono[i];
                        mostrar += "\n";
                        mostrar += "\n";
                       
                        }
                        
                      }
                        JOptionPane.showMessageDialog(null, mostrar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Todavia no hay pasajeros");
                    }
   
                    break;
                case 4:
                    
                    if (aux2 == true) {
                        JOptionPane.showMessageDialog(null, "Para poder eliminar un dato debe seleccionar el numero del asiento");
                        mostrar = "Asientos disponibles para eleminar";
                        for (int i = 0; i < 183; i++) {
                            if (i%20==0) {
                                mostrar += "\n";
                            }
                            if (nombreYapellidos[i] != null) {
                                mostrar += i+1;
                                mostrar += "  ";
                            }
                        }
                        
                        
                        do {
                            asientoAEeliminar = Integer.parseInt(JOptionPane.showInputDialog(mostrar+"\n Digite el numero del asiento"));
                            if (nombreYapellidos[asientoAEeliminar-1] != null) {
                               confimacion = JOptionPane.showConfirmDialog(null, "Desea eliminar esta informacion"+
                                    "\nNumero de asiento: "+(asientoAEeliminar)+
                                    "\nNombres y apellidos:  "+nombreYapellidos[asientoAEeliminar-1]+
                                    "\nNacionalidad:  "+nacionalidad[asientoAEeliminar-1]+
                                    "\nEdad:  "+edad[asientoAEeliminar-1]+
                                    "\nNumero de identificacion:  "+numeroDeDocumento[asientoAEeliminar-1]+
                                    "\nNumero de telefono:  "+numeroDeTelefono[asientoAEeliminar-1], 
                                    "",JOptionPane.YES_NO_OPTION, 
                                    JOptionPane.INFORMATION_MESSAGE);
                            
                            if (confimacion == 0) {
                                asientoAEeliminar--;
                                for (int i = asientoAEeliminar; i < asientoAEeliminar+1; i++) {
                                    nombreYapellidos[i] = null;
                                    nacionalidad[i] = null;
                                    edad[i] = 0;
                                    numeroDeDocumento[i] = 0;
                                    numeroDeTelefono[i] = 0;
                                    
                                    JOptionPane.showMessageDialog(null, "Informacion eliminada");
                                    }
  
                            } 
                            } else {
                                JOptionPane.showMessageDialog(null, "El asiento no exite");
                            }
                            
                        } while (confimacion == 1);
                           
                    } else {
                        JOptionPane.showMessageDialog(null, "Todavia no hay pasajeros");
                    }

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Fin del programa");
                    aux1 = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }
        }
    }
}
