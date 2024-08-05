package nam.dev.test_training.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nam.dev.test_training.DTO.ProductDTO;
import nam.dev.test_training.entity.Brand;
import nam.dev.test_training.entity.Product;
import nam.dev.test_training.entity.Status;
import nam.dev.test_training.entity.SubCate;
import nam.dev.test_training.repo.BrandRepo;
import nam.dev.test_training.repo.ProductDTORepo;
import nam.dev.test_training.repo.ProductRepo;
import nam.dev.test_training.repo.StatusRepo;
import nam.dev.test_training.repo.SubCateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductDTORepo productDTORepo;

    private final ProductRepo productRepo;

    private final BrandRepo brandRepo;

    private final StatusRepo statusRepo;

    private final SubCateRepo subCateRepo;

    @GetMapping("/hien-thi")
    public ResponseEntity<List<ProductDTO>> hienThi() {
        return ResponseEntity.ok(productDTORepo.getAll());
    }

    @GetMapping("/hien-thi1")
    public ResponseEntity<List<Product>> hienThi1() {
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody Product productReq, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrorMessages(bindingResult);
            return ResponseEntity.badRequest().body(errors);
        }

        SubCate subCate = subCateRepo.findById(productReq.getSubCate().getId()).get();
        Status status = statusRepo.findById(productReq.getStatus().getId()).get();

        Set<Brand> brands = new HashSet<>(brandRepo.findAllById(productReq.getBrandSet()
                .stream()
                .map(Brand::getId)
                .collect(Collectors.toSet())));

        Product product = new Product();
        product.setProductName(productReq.getProductName());
        product.setSellPrice(productReq.getSellPrice());
        product.setColor(productReq.getColor());
        product.setQuantity(productReq.getQuantity());
        product.setOriginPrice(productReq.getOriginPrice());
        product.setSubCate(subCate);
        product.setStatus(status);
        product.setBrandSet(brands);
        productRepo.save(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("detail/{ma}")
    public ResponseEntity<ProductDTO> detail(@PathVariable("ma") Long ma) {
        if(productDTORepo.getById(ma)==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productDTORepo.getById(ma));
    }

    @PutMapping("update/{ma}")
    public ResponseEntity<Object> update(@PathVariable("ma") Long ma,@Valid @RequestBody Product productReq,BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrorMessages(bindingResult);
            return ResponseEntity.badRequest().body(errors);
        }

        SubCate subCate = subCateRepo.findById(productReq.getSubCate().getId()).get();
        Status status = statusRepo.findById(productReq.getStatus().getId()).get();

        Set<Brand> brands = new HashSet<>(brandRepo.findAllById(productReq.getBrandSet()
                .stream()
                .map(Brand::getId)
                .collect(Collectors.toSet())));

        Optional<Product> optionalProduct = productRepo.findById(ma);
        Product product = null;
        if(!optionalProduct.isEmpty()){
            product = optionalProduct.get();
            product.setProductName(productReq.getProductName());
            product.setSellPrice(productReq.getSellPrice());
            product.setColor(productReq.getColor());
            product.setQuantity(productReq.getQuantity());
            product.setOriginPrice(productReq.getOriginPrice());
            product.setSubCate(subCate);
            product.setStatus(status);
            product.setBrandSet(brands);
            productRepo.save(optionalProduct.get());
        }
        return ResponseEntity.ok(product);
    }



    public Map<String, String> getErrorMessages(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }


}
