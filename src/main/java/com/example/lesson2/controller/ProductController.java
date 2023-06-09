package com.example.lesson2.controller;

import com.example.lesson2.Form.ProductForm;
import com.example.lesson2.ProductDao.ProductDao;
import com.example.lesson2.ProductRecord.ProductRecord;
import com.example.lesson2.ProductService.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product-list")
    public String getProductList(Model model) {
        var productData = productService.findAll();
        model.addAttribute("productData", productData);
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        //idに該当する商品情報を取得
        var SelectData = productService.findById(id);
        //エラー処理
        if (SelectData == null) {
            return "error-page";
        }
        //賞品情報をModelに追加
        model.addAttribute("SelectData", SelectData);
        return "product-details";
    }

//    @ExceptionHandler
//    public String handleException(Exception e) {
//        return "error-page";
//    }

    /*-------------------------Insert(新規追加)--------------------------*/
    @GetMapping("/product-add")
    public String insertData(@ModelAttribute("ProductForm") ProductForm productForm) {
        return "product-add";
    }

    @GetMapping("/insert")
    public String newInsert(@ModelAttribute("ProductForm") ProductForm productForm) {
        return "product-add";
    }

    @PostMapping("insert")
    public String insert(@Validated @ModelAttribute("ProductForm") ProductForm productForm, BindingResult bindingResult, Model model) {
        //バリデーション
        if (bindingResult.hasErrors()) {
            System.out.println("エラー");
            return "product-add";
        }
        productService.insert(new ProductRecord(0, productForm.getProductName(), productForm.getProductPrice()));
        var productData = productService.findAll();
        model.addAttribute("productData", productData);
        return "redirect:/product-list";
    }

    /*-------------------------Update(新規追加)--------------------------*/
    @GetMapping("/product/update/{id}")
    public String updateForm(@PathVariable("id") int id, @ModelAttribute("productForm") ProductForm productForm, Model model) {
        //idに該当する商品情報を取得
        var SelectData = productService.findById(id);
        //エラー処理
        if (SelectData == null) {
            return "error-page";
        }
        //賞品情報をModelに追加
        model.addAttribute("product", SelectData);

        return "product-update";
    }

    @PostMapping("update")
    public String update(@RequestParam(name = "updateID") int id, @Valid @ModelAttribute("productForm") ProductForm productForm, BindingResult result, Model model) {
        //バリデーション
        if (result.hasErrors()) {
            System.out.println("エラー");
            return "product-update";
        }
        System.out.println("今から更新するよ～");
        productService.update(new ProductRecord(id, productForm.getProductName(), productForm.getProductPrice()));
        System.out.println("今更新したよ～");
        var productData = productService.findAll();
        model.addAttribute("product", productData);
        return "redirect:/product-list";
    }
    /*-------------------------delete(削除)--------------------------*/

    @GetMapping("/product/delete/{id}")
    public String deleteForm(@PathVariable("id") int id, Model model) {
        System.out.println("GET: 削除するよ～");
        // idに該当する商品情報を取得
        var selectData = productService.findById(id);
        System.out.println("GET: 削除したよ～");
        // エラー処理
        if (selectData == null) {
            System.out.println("エラー！");
            return "error-page";
        }
        // 商品情報をModelに追加
        model.addAttribute("product", selectData);
        return "product-delete";
    }

    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        System.out.println("POST: 削除するよ～");
        // 商品を削除
        productService.delete(id);
        System.out.println("POST: 削除したよ～");
        // 削除成功メッセージをリダイレクト先に渡す
        redirectAttributes.addFlashAttribute("message", "商品を削除しました");
        return "redirect:/product-list";
    }
}