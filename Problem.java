/*	
 -----------------DESCRIPTION---------------------
< Problem Description>
We want to develop a program which manages the purchasing of products. There are 10 different types of products in a stock. Each product has a unique identification number from 1 to 10. We want to maintain the price of each product type, the identification number of each product type and the number of items of each kind of product that are purchased.  A customer can buy several products at once. For example, you can show purchasing information such as:
•	 1 item from product type 5,
•	 4 items from product 2,
•	 7 items from product type 1. 
Given the above information of a product, the program should perform the following functions.

1. View the unit price of a product
2. Add an item to the information system when a product is purchased
3. Calculate the total price of a product
3.	Detailed Description of each function:
a)	View the unit price of a product: Scan the product identification number and show the price of the product( 5pt)
b)	Add a purchasing product to the system(5pt):
--->Scan the product identification number and save the price of the item of the purchased product.
--->If this product is already in a purchasing list, add the quantity (number) of the product. 
--->Subtract the number (quantity) of the purchased product in stock.
--->If the quantity of a selected product in the stock is not sufficient (the total stock of the product is less than the number of products to be purchased), display the error message “the product is out of stock” on the screen.
C)	Calculate the total price (5pt): Display the total price of the purchased items and exit the program.
4.	User Interface Requirements: 
•	Once the program starts, the program should display to the user the menu to select one of the above three function.
•	 “View the unit price” and “Add a purchasing product” function can be performed repeatedly.
•	Finally selecting “Calculate the total price” function and terminate the program
e.g.
           int[] unit_price;			
          void view_unit_price(...) { ... } 	
•	Initial value of product price information or stock information can be used and configured in program.
•	How to use basic array in java ?
e.g. 
a)    int[] unit_price = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
// when initialize integer array, assign the size.
c)	int[] unit_price = new int[10]; // create array to save 10 integer dynamically


*/
import java.util.Scanner;

public class Problem {

	static Scanner input =new Scanner(System.in);
	
	static int[] unit_price = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; //물품타입 1-10번의 물건의 가격 
	
	static int[] unit_stock= {10,20,80,4,52,4,12,54,100,34}; //물건의 재고
	
	static int totalprice=0,a=0,b=0; 
	
	static int[] list = new int[10]; //구매한 개수 담는 배
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=true;
		
		while(flag){
			menu(); //메뉴출력 
			System.out.print("select menu: ");
			int number=input.nextInt();
			
			switch(number) {
			case 1:
				view_unit_price();
				break;
			case 2:	
				add();
				break;
			case 3:
				sum();
				flag=false; //false 되면서 반복문 나가면서 종료 
				break;
			default: 
				System.out.println("메뉴번호를 다시 입력해주세요.");
				break;
			}
			
		}
		
	}

	public static void menu() {
		System.out.println();
		System.out.println("1.View the unit price of a product");
		System.out.println("2.Add an item to the information system when a product is purchased");
		System.out.println("3.Calculate the total price of a product");
		System.out.println();
	}
	public static void view_unit_price() {
		boolean crift=true;
		while(crift) {//예외처리를 위한 반복문 
			System.out.println();
			System.out.print("push your product number : "); //메뉴 번호 입력 
			 a=input.nextInt();
		
			if(a<1 || a>10) {
				System.out.println("제품번호 1-10 으로 입력해주세요\n");
			}
			else {
				crift=false; //범위 안에 입력받으면 반복문 나간다. 
				
			}
		
		}
			int i=0;
			for(i=0;i<10;i++) { //반복문 돌면서 입력받은 타입과 같은 가격 불러오기 
				if((a-1)==i) {
					
					System.out.printf("unit price of a product : %d%n",unit_price[i]);
				}
			}
		
	
	}
	public static void add(){
		boolean crit=true;
		while(crit){  
		System.out.println("push your product number : "); //상품번호 
		b=input.nextInt();
			
			if(b<1||b>10) {  //제품 타입 입력 예외처
				System.out.println("the product is not exits please push again \n");
				
			}
			else {
				crit=false;
			}
		}
	
		System.out.println("write the number you want to purchase :  "); //상품 구매 개수 입력 
		int stock=input.nextInt();
		
		
		int i=0;
		for(i=0;i<10;i++) {
			if((b-1)==i) {
					if(unit_stock[i]>=stock) {
							unit_stock[i]=unit_stock[i]-stock; //상품 구매한 만큼 재고 빼기 
							totalprice+=unit_price[i]*stock; //구매한 갯수만큼 가격 저장  
							list[i]+=stock; //구매한 갯수 저장 
						}
					else if(unit_stock[i]<stock){
							System.out.println("the product is out of stock"); //재고 없으면 예외처리 
					}
			
			}
		
		}
	
	}
	
	public static void sum() {
		
		System.out.println("------Purchasing List------"); //구매한 제품 타입번호와 개수 출력 
        for (int i = 0; i < 10; i++)
            if (list[i] != 0) {
                System.out.printf("%d items from product type %d \n",list[i],i+1 );
                
            }
        System.out.println();
        System.out.println("--------total price--------"); //총 구매한 가격 출력 
		System.out.printf("total price of a product is %d",totalprice);
		System.out.println("");
		
		
		
	}
	
	
}



