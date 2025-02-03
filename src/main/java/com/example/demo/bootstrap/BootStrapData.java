package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (productRepository.count() == 0) {

            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            Product floatRod = new Product("Float Rod", 100.0, 15);
            Product DriftRod = new Product("Drift Rod", 110.0, 10);
            Product TwitchingRod = new Product("Twitching Rod", 90.0, 8);
            Product TrollingRod = new Product("Trolling Rod", 125.0, 20);
            Product CenterPin = new Product("Centerpin Rod", 200.0, 5);

            productRepository.save(floatRod);
            productRepository.save(DriftRod);
            productRepository.save(TwitchingRod);
            productRepository.save(TrollingRod);
            productRepository.save(CenterPin);


            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());

            InhousePart blanks = new InhousePart();
            blanks.setName("Blanks");
            blanks.setId(1);
            blanks.setPrice(50);
            blanks.setInv(20);
            blanks.setMaxInventory(50);
            blanks.setMinInventory(1);
            inhousePartRepository.save(blanks);

            OutsourcedPart guides = new OutsourcedPart();
            guides.setName("Guides");
            guides.setId(2);
            guides.setPrice(5);
            guides.setInv(100);
            guides.setMaxInventory(125);
            guides.setMinInventory(1);
            outsourcedPartRepository.save(guides);

            InhousePart reelSeats = new InhousePart();
            reelSeats.setName("Reel Seats");
            reelSeats.setId(3);
            reelSeats.setPrice(15);
            reelSeats.setInv(5);
            reelSeats.setMaxInventory(50);
            reelSeats.setMinInventory(1);
            inhousePartRepository.save(reelSeats);

            OutsourcedPart cork = new OutsourcedPart();
            cork.setName("Cork");
            cork.setId(4);
            cork.setPrice(10);
            cork.setInv(100);
            cork.setMaxInventory(125);
            cork.setMinInventory(1);
            outsourcedPartRepository.save(cork);

            OutsourcedPart thread = new OutsourcedPart();
            thread.setName("Thread");
            thread.setId(5);
            thread.setPrice(5);
            thread.setInv(60);
            thread.setMaxInventory(100);
            thread.setMinInventory(1);
            outsourcedPartRepository.save(thread);

        }

    }
}
