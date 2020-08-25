import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class InventoryAllocator {
	
	private Map<String, Integer> orders;
	private ArrayList<Map<String, Object>> inventories;
	private Map<String, Map<String, Integer>> warehouseOrders; 
	private ArrayList<Map<String, Map<String, Integer>>> cheapestShipment;
	
	public InventoryAllocator(Map<String, Integer> orders, ArrayList<Map<String, Object>> inventories) {
		this.orders = orders;
		this.inventories = inventories;
		this.warehouseOrders = new TreeMap<>();
		this.cheapestShipment = new ArrayList<>();
		
	}
	
	/* This function calls populateWarehouseOrders() first to populate the map 'warehouseOrders' with the initial requested orders
	 * from the warehouses and then calls adjustOrders() which removes any orders from 'warehouseOrders' that could not be fulfilled entirely.
	 * The ArrayList 'cheapestShipment' will contain the result of the cheapest way the Map of orders can be shipped.
	 */
	public ArrayList<Map<String, Map<String, Integer>>> computeOptimalAllocation(){
		
		populateWarehouseOrders();
		adjustOrders();
		
		return cheapestShipment;
		
	}
	
	/* After populateWarehouseOrders() is finished executing, this method is called to remove any orders that could not be fulfilled entirely from 
	 * the map called 'orders'. The final results are extracted from 'warehouseOrders' and inserted into cheapestShipment which is returned by 
	 * computeOptimalAllocation().
	 */
	private void adjustOrders() {
		

		for(Map.Entry<String, Map<String, Integer>> warehouseEntry : this.warehouseOrders.entrySet()) {
			
			if(warehouseEntry.getValue() != null) {
			
				for(String key : warehouseEntry.getValue().keySet()) {
					
					if(this.orders.containsKey(key))
						warehouseEntry.getValue().remove(key);
					
				}
				
				if(warehouseEntry.getValue().size() > 0) {
					
					Map<String, Map<String, Integer>> currentOrders = new TreeMap<>();
					currentOrders.put(warehouseEntry.getKey(), warehouseEntry.getValue());
					cheapestShipment.add(currentOrders);
					
				}
			}
		}
	}
	
	/* This function iterates through the ArrayList 'inventories' to see if the orders can be fulfilled. If there is a matching inventory
	 * item with a order item, then the item in the Map 'orders' will be reduced accordingly or popped off if its value hits 0. The 
	 * requested order by the warehouse will then be stored in 'warehouseOrders' which will be adjusted after this methods execution.
	 */
	private void populateWarehouseOrders() {
		
		for(Map<String, Object> m : this.inventories) {
			
			String currentWarehouse = (String) m.get("name");
			warehouseOrders.put(currentWarehouse, null);
			
			@SuppressWarnings("unchecked")
			Map<String, Integer> warehouseInventory = (Map<String, Integer>) m.get("inventory");
			
			for(Map.Entry<String, Integer> entry : warehouseInventory.entrySet()) {
				
				if(this.orders.containsKey(entry.getKey())) {
					
					int reduction = this.orders.get(entry.getKey()) - entry.getValue();
					
					if(reduction <= 0) {
						this.orders.remove(entry.getKey());
					} 
					
					else {
						this.orders.replace(entry.getKey(), reduction);
					}
					
					if(warehouseOrders.get(currentWarehouse) == null) {
						warehouseOrders.replace(currentWarehouse, new TreeMap<String, Integer>());
					}
					
					int totalOrders = (reduction < 0) ? (entry.getValue() + reduction) : entry.getValue();
					warehouseOrders.get(currentWarehouse).put(entry.getKey(), totalOrders);
				}
			}
		}
		
	}

}
