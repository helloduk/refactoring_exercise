import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;
	private final Customers customers = new Customers();
	private final Videos videos = new Videos();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.registerCustomer() ; break ;
				case 4: ui.registerVideo() ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		customers.clearRentals(customerName);
	}

	public void returnVideo() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		if (!customers.hasCustomer(customerName)) {
			return;
		}

		System.out.println("Enter video title to return: ") ;
		String videoTitle = scanner.next() ;

		customers.returnVideo(customerName, videoTitle);
	}

	private void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		customers.customers.add(james) ;
		customers.customers.add(brown) ;

		Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
		Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;
		videos.videos.add(v1) ;
		videos.videos.add(v2) ;

		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;

		james.addRental(r1) ;
		james.addRental(r2) ;
	}

	public void listVideos() {
		System.out.println("List of videos");

		videos.listVideos();

		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");

		customers.listCustomers();

		System.out.println("End of list");
	}

	public void getCustomerReport() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		customers.getReport(customerName);
	}

	public void rentVideo() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		if (!customers.hasCustomer(customerName)) {
			return;
		}

		System.out.println("Enter video title to rent: ") ;
		String videoTitle = scanner.next() ;

		Video foundVideo = videos.getVideo(videoTitle);
		if (foundVideo == null) return;

		customers.rentVideo(customerName, foundVideo);
	}

	private void registerVideo() {
		System.out.println("Enter video title to register: ") ;
		String title = scanner.next() ;

		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		int videoType = scanner.nextInt();

		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		int priceCode = scanner.nextInt();

		Date registeredDate = new Date();
		videos.addVideo(new Video(title, videoType, priceCode, registeredDate));
	}

	private void registerCustomer() {
		System.out.println("Enter customer name: ") ;
		String name = scanner.next();

		customers.addCustomer(name);
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
