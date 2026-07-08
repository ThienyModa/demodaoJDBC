package Application;

import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("=== TEST 1: Seller FingbyID ===");
		Seller seller = sellerDao.findById(3); 
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller findbyDepartment ===");
		Departament departament = new Departament(2, null);
		List<Seller> list = sellerDao.findByDepartment(departament);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
	}

}
