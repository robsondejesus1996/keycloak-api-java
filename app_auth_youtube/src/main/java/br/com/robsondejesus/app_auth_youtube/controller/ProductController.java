package br.com.robsondejesus.app_auth_youtube.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    public String list(){
        return "Listando produtos";
    }

    public String create(){
        return "Cadastrando produtos";
    }
}
