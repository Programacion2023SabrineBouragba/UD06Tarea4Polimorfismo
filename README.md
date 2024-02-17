# UD06Tarea4Polimorfismo
## Polimorfismo y Clases Abstractas

# 3.
- a. 
 
 -> El código devolvería:
  -	Querido Amy,
  Saludos veraniegos!
  
  -	Querido Bob,
  Con amor y besos,
  XXX
  -	Querido Cindy,
  Feliz 17 Aniversario

	
 
- b. 
	 
 -> La correcta es la la v= new SanValentin(“Elroy”, 3), porque cuadra con la declaración de: SanValentin=v; , el resto no cuandra las declaraciones con las asignaciones.

- 4. 
	- a. 
 
  -	Ok, porque utiliza el constructor de su clase hija
  -	No, porque utiliza el constructor de su clase hermana
  -	No, porque utiliza el constructor de su clase padre
  -	No, porque utiliza el constructor subclase de su case hermana
  -	Ok, porque utiliza un constructor de la subclase
  -	No, porque utiliza el constructor de su clase padre
  -	Ok, porque utiliza una de sus subclases
  -	No, porque utiliza un constructor de su clase hermana
 
- 5. 
 
- a. Sí que tiene constructor. No se puede crear directamente, hay que crear una subclase de esta clase abstracta y luego instanciarla.
- b. Una interfaz puede tener solo métodos abstractos e implementados por las clases que las implementen, y variables constantes. En cambio, una clase abstracta puede tener métodos abstractos y métodos concretos, también variables y constructores.
- c. Sí que puede implementar una interfaz, ya que esta permite que todas sus subclases hereden esta implementación y luego la ajusten a sus necesidades, teniendo en cuenta las limitaciones que tiene java en la herencia.

- 6. 
 
 
-> //clase abstracta
public abstract class Forma{
	protected int numLados;
	
->//constructor
public Forma(int numLados){
  this.numLados=numLados;
}
->//getter
public int getNumLados(){
return numLados;
}

->//método abstracto
public abstract double getArea();
public abstract double getPerimetro();
}
->//subclase
public class Rectángulo extends Forma{
private double ancho;
private doble alto;

->//constructor
public Rectangulo(int numLados, double ancho, double alto){
	super(numLados);
	this.ancho= ancho;
	this.alto=alto;
}
 
-> //implementar metodos abstractos(superclase)
public double getArea(){
return ancho * alto;
}
public double getPerimetro(){
return (2*(ancho+alto));
}
}

->//subclase
public class Triangulo extends Forma{
private double base;
private doble altura;

-> //constructor
public Triangulo(int numLados, double base, double altura){
	super(numLados);
	this.ancho= base;
	this.alto=altura;
}
-> //implementar metodos abstractos(superclase)
public double getArea(){
return ((base*altura)/2);
}
public double getPerimetro(){
return ;
}
 
-> //método main
Public class Main{
public static void main(String[] atgs){
	-> //rectangulo
	Rectangulo rectangulo=new Rectangulo(4, 8.5, 13.5);
	Sout(“Área rectangulo:” + rectangulo.getArea());
	Sout(“Perímetro rectángulo: ” + rectángulo.getPerimetro()); 
}
}
