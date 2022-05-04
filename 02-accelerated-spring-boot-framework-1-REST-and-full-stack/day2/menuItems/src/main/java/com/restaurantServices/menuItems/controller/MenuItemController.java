package com.restaurantServices.menuItems.controller;

import com.restaurantServices.menuItems.MenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class MenuItemController {

    private List<MenuItem> menuItems;

    public MenuItemController() {
        this.menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(menuItemId++, "Mozarella Sticks", 3.50, "Fried cheese sticks"));
        menuItems.add(new MenuItem(menuItemId++, "Cheeseburger", 12.00, "To all be fatty special sauce"));
        menuItems.add(new MenuItem(menuItemId++, "Ice cream sundae", 20.00, "Two scoops, no bananas"));
    }

    private static int menuItemId = 1;


    // show all menu items
    // "/menuitems GET"
    @RequestMapping(value="/menuitems", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MenuItem> getItems() {
        return menuItems;
    }

    @RequestMapping(value="/menuitems", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MenuItem createItem(@RequestBody MenuItem menuItem) {
        menuItem.setId(menuItemId++);
        menuItems.add(menuItem);
        return menuItem;
    }

    @RequestMapping(value="/menuitems/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable int id) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getId() == id) {
                menuItems.remove(i);
                return;
            }
        }
    }

    @RequestMapping(value="/menuitems/{id}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MenuItem getSingleItem(@PathVariable int id) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getId() == id) {
                return menuItems.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value="/menuitems/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public MenuItem updateItem(@PathVariable int id, @RequestBody MenuItem item) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getId() == id) {
                item.setId(id);
                menuItems.set(i, item);
                return menuItems.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value="/menuitems/byname/{name}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MenuItem getSingleItem(@PathVariable String name) {
        for (int i = 0; i < menuItems.size(); i++) {
        if (menuItems.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
            return menuItems.get(i);
        }
        }
        return null;
    }
}