package Application;

import java.util.Date;

import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Departament obj = new Departament(1, "Books");
		
		Seller seller = new Seller(21, "Thieny", "thienyam@hotmail.com", new Date(), 3000.00, obj);
		
		
		System.out.println(seller);
	}

}
