package Application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Thieny", "thienyam@gmail.com", new Date(), 4000.0,departament);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
	
		
	    System.out.println("\n=== TEST 5: Seller Update ===");
	    seller = sellerDao.findById(1);
	    seller.setName("Marta Whaine");
	    sellerDao.update(seller);
	    System.out.println("Update Completed");
	    
	    System.out.println("\n=== TEST 6: Seller Delete ===");
	    System.out.println("Enter id for delete test: ");
	    int id = sc.nextInt();
	    sellerDao.deleteById(id);
	    System.out.println("Delete completed");
	    
	    sc.close();
	    
		}
	}
