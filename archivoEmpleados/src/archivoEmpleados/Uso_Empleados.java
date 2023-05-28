import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleados{
    public static void main(String[] args) {

/* Forma antigua que tarda mucho tiempo si tienes bastantes datos para ingresar
        empleado miempleado1= new empleado("Martin",5500,2003,9,8);
        empleado miempleado2= new empleado("Cristian",7500,2002,5,5);
        empleado miempleado3= new empleado("Arelys",10000,2000,10,18);

        miempleado3.setSubeSueldo(30);
        miempleado2.setSubeSueldo(10);
        miempleado1.setSubeSueldo(10);

        System.out.println(miempleado1.getSueldo()+miempleado1.getNombre()+miempleado1.getAltaContrato());
        */



        //Polimorfismo, consiste desde el main cuando vamos a llamar a las clases que justamente que son diferentes y tenemos
        //una forma para ingresar datos

        //Primero que todo ingresamos los datos de la otra clase a tratar

        Jefatura jefe_RRHH=new Jefatura("Martin",100000,2003,8,9);

        jefe_RRHH.setIncentivo(2895);

      //  luego justamente la vamos a incluir en nuestro array, por lo que tenemos que cambiar la capacidad de array por
        //        si se nos queda corto




        empleado[] misEmpleados=new empleado[5];


        //Aqui abarca el primer metodo que tienes que tienes mas parametros (total: 5) >>>>>>

        misEmpleados[0]=new empleado("Martin",5500,2003,9,8);

        misEmpleados[1]=new empleado("Cristian",10500,2002,5,5);

        //Aqui estaria el polimorfismo, justamente estoy mezclando dos clases en un array
        //Se puede hacer asi
        misEmpleados[2]=jefe_RRHH;
        //o asi
        misEmpleados[3]=new Jefatura("Alonso",5000,1968,06,01);

        //En cambio en el otro metodo como abarca distinto numero de parametro que seria 1, pues solo introducimos
        //ese parametro y JAVA entiendo que estamos llamando a este constructor y no al otro

        misEmpleados[4]=new empleado("Jairo");


        for (empleado e:misEmpleados) {
            e.setSubeSueldo(4);
        }
        for (empleado e:misEmpleados) {
            System.out.println("Nombre "+e.getNombre()+" Sueldo: "+ e.getSueldo() + "Fecha de Alta: "+e.getAltaContrato());
        }



    }
}
class empleado {
    private String nombre;
    private double sueldo;
    private Date altaContrato;


    public empleado(String nom, double sue, int ano, int mes, int dias) {
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(ano, mes - 1, dias);
        altaContrato = calendario.getTime();
    }

    /*SobreCarga de constructores*/

    //Debe de recibir un numero diferente de parametros al otro metodo constructor para poder funcionar
    public empleado(String nom) {

        this(nom, 3000, 2000, 1, 1);


    }


    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getAltaContrato() {
        return altaContrato;
    }

    public void setSubeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }


}

