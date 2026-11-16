package com.example.demo.service;


import com.example.demo.model.InventoryModel;
import com.example.demo.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class InventoryService {

        private final InventoryRepository productRepository;

        public InventoryService(InventoryRepository productRepository) {
            this.productRepository = productRepository;
        }

        //add
        public InventoryModel addProduct(InventoryModel product) {
            return productRepository.save(product);
        }

        // update
        public InventoryModel updateQuantity(Long id, int quantity) {
            InventoryModel product = productRepository.findById(id)
                    .orElseThrow(() ->
                            new RuntimeException("Product not found with id: " + id));

            product.setQuantity(quantity);

            return productRepository.save(product);
        }

        // delete
        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }

        //view
        public List<InventoryModel> getAllProducts() {

            return productRepository.findAll();
        }
    }

