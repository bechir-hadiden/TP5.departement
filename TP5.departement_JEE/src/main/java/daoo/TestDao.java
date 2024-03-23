package daoo;


import java.util.List;
import metier.entities.Departement;
public class TestDao {
public static void main(String[] args) {
	DepartementDaolmpl pdao= new DepartementDaolmpl();
Departement prod= pdao.save(new Departement("departement informatique ", 3));
System.out.println(prod);
List<Departement> prods =pdao.DepartementParMC("departement");
for (Departement p : prods)
System.out.println(p);
}
}