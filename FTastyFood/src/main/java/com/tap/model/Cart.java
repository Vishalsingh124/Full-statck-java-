package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private HashMap<Integer, CartItem> items;

	public Cart() {
		items = new HashMap<>();
	}

	public void addCartItem(CartItem item) {
		int itemId = item.getItemId();
		if (items.containsKey(itemId)) {
			CartItem existing = items.get(itemId);
			existing.setQuantity(existing.getQuantity() + item.getQuantity());
		} else {
			items.put(itemId, item);
		}
	}

	public void updateItem(int itemId, int quantity) {
		if (items.containsKey(itemId)) {
			if (quantity <= 0) {
				items.remove(itemId);
			} else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}

	public void removeItem(int itemId) {
		items.remove(itemId);
	}

	public Map<Integer, CartItem> getItem() {
		return items;
	}

	public double getTotalPrice() {
		return items.values().stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
	}

	public void clear() {
		items.clear();
	}
}
