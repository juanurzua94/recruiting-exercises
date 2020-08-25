import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class InventoryAllocatorTest {
	
	public static void Test1() {
		// TEST #1
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("apple", 1);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("apple", 1);
				
		warehouse.put("inventory", inventory);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
				
		System.out.println("Input: { apple: 1 }, [{ name: owd, inventory: { apple: 1 } }]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
		
	}
	
	public static void Test2() {
		// TEST #2
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("apple", 1);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("apple", 0);
				
		warehouse.put("inventory", inventory);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
				
		System.out.println("Input: { apple: 1 }, [{ name: owd, inventory: { apple: 0 } }]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}
	
	public static void Test3() {
		// TEST #3
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("apple", 10);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("apple", 5);
				
		warehouse.put("inventory", inventory);
		
		Map<String, Object> warehouse2 = new TreeMap<>();
		warehouse2.put("name", "dm");
		Map<String, Integer> inventory2 = new TreeMap<>();
		inventory2.put("apple", 5);
		
		warehouse2.put("inventory", inventory2);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
		warehouseInventory.add(warehouse2);
				
		System.out.println("{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}
	
	public static void Test4() {
		// TEST #4
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("apple", 15);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("apple", 15);
				
		warehouse.put("inventory", inventory);
		
		Map<String, Object> warehouse2 = new TreeMap<>();
		warehouse2.put("name", "dm");
		Map<String, Integer> inventory2 = new TreeMap<>();
		inventory2.put("apple", 5);
		
		warehouse2.put("inventory", inventory2);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
		warehouseInventory.add(warehouse2);
				
		System.out.println("{ apple: 15 }, [{ name: owd, inventory: { apple: 15 } }, { name: dm, inventory: { apple: 5 }}]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}
	
	public static void Test5() {
		// TEST #5
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("apple", 15);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("banana", 15);
				
		warehouse.put("inventory", inventory);
		
		Map<String, Object> warehouse2 = new TreeMap<>();
		warehouse2.put("name", "dm");
		Map<String, Integer> inventory2 = new TreeMap<>();
		inventory2.put("apple", 15);
		
		warehouse2.put("inventory", inventory2);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
		warehouseInventory.add(warehouse2);
				
		System.out.println("{ apple: 15 }, [{ name: owd, inventory: { banana: 15 } }, { name: dm, inventory: { apple: 15 }}]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}
	
	public static void Test6() {
		// TEST #6
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("apple", 15);
		orders.put("mango", 10);
		orders.put("banana", 5);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("banana", 15);
		inventory.put("mango", 2);
				
		warehouse.put("inventory", inventory);
		
		Map<String, Object> warehouse2 = new TreeMap<>();
		warehouse2.put("name", "dm");
		Map<String, Integer> inventory2 = new TreeMap<>();
		inventory2.put("apple", 15);
		inventory2.put("mango", 3);
		
		warehouse2.put("inventory", inventory2);
		
		Map<String, Object> warehouse3 = new TreeMap<>();
		warehouse3.put("name", "mx");
		Map<String, Integer> inventory3 = new TreeMap<>();
		inventory3.put("grape", 5);
		inventory3.put("mango", 7);
		
		warehouse3.put("inventory", inventory3);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
		warehouseInventory.add(warehouse2);
		warehouseInventory.add(warehouse3);
		
		System.out.println("{ apple: 15, mango: 10, banana: 5 }, [{ name: owd, inventory: { banana: 15, mango: 2 } }, { name: dm, inventory: { apple: 15, mango: 3 }}, { name: mx, inventory: { grape: 5, mango: 7}}]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}
	
	public static void Test7() {
		// TEST #7
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("peach", 2);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("banana", 15);
		inventory.put("mango", 2);
				
		warehouse.put("inventory", inventory);
		
		Map<String, Object> warehouse2 = new TreeMap<>();
		warehouse2.put("name", "dm");
		Map<String, Integer> inventory2 = new TreeMap<>();
		inventory2.put("apple", 15);
		inventory2.put("mango", 3);
		
		warehouse2.put("inventory", inventory2);
		
		Map<String, Object> warehouse3 = new TreeMap<>();
		warehouse3.put("name", "mx");
		Map<String, Integer> inventory3 = new TreeMap<>();
		inventory3.put("grape", 5);
		inventory3.put("mango", 7);
		
		warehouse3.put("inventory", inventory3);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
		warehouseInventory.add(warehouse2);
		warehouseInventory.add(warehouse3);
		
		System.out.println("{ peach : 2 }, [{ name: owd, inventory: { banana: 15, mango: 2 } }, { name: dm, inventory: { apple: 15, mango: 3 }}, { name: mx, inventory: { grape: 5, mango: 7}}]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}
	
	public static void Test8() {
		// TEST #8
		Map<String, Integer> orders = new TreeMap<>();
		orders.put("grape", 6);
				
		Map<String, Object> warehouse = new TreeMap<>();
		warehouse.put("name", "owd");
		Map<String, Integer> inventory = new TreeMap<>();
		inventory.put("banana", 15);
		inventory.put("mango", 2);
				
		warehouse.put("inventory", inventory);
		
		Map<String, Object> warehouse2 = new TreeMap<>();
		warehouse2.put("name", "dm");
		Map<String, Integer> inventory2 = new TreeMap<>();
		inventory2.put("apple", 15);
		inventory2.put("mango", 3);
		
		warehouse2.put("inventory", inventory2);
		
		Map<String, Object> warehouse3 = new TreeMap<>();
		warehouse3.put("name", "mx");
		Map<String, Integer> inventory3 = new TreeMap<>();
		inventory3.put("grape", 8);
		inventory3.put("mango", 7);
		
		warehouse3.put("inventory", inventory3);
				
		ArrayList<Map<String, Object>> warehouseInventory = new ArrayList<>();
		warehouseInventory.add(warehouse);
		warehouseInventory.add(warehouse2);
		warehouseInventory.add(warehouse3);
		
		System.out.println("{ grape : 6 }, [{ name: owd, inventory: { banana: 15, mango: 2 } }, { name: dm, inventory: { apple: 15, mango: 3 }}, { name: mx, inventory: { grape: 8, mango: 7}}]");
		System.out.println("Output: " + new InventoryAllocator(orders, warehouseInventory).computeOptimalAllocation());
	}

}
