package com.example.demo.controller;


import com.example.demo.model.InventoryModel;
import com.example.demo.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/products")
    public class InventoryController {

        private final InventoryService productService;

        public InventoryController(InventoryService productService) {
            this.productService = productService;
        }

        //add product
        @PostMapping
        public InventoryModel addProduct(@RequestBody InventoryModel product) {
            return productService.addProduct(product);
        }

        //update
        @PutMapping("/{id}/quantity")
        public InventoryModel updateQuantity(
                @PathVariable Long id,
                @RequestParam int quantity) {

            return productService.updateQuantity(id, quantity);
        }

        //delete product
        @DeleteMapping("/{id}")
        public String deleteProduct(@PathVariable Long id) {

            productService.deleteProduct(id);

            return "Product deleted successfully";
        }

        //view
        @GetMapping
        public List<InventoryModel> getAllProducts() {
            return productService.getAllProducts();
        }
    }

