package com.groupoffive.listapp.routers;

import com.groupoffive.listapp.controllers.ProductsController;
import com.groupoffive.listapp.exceptions.CategoryNameAlreadyInUseException;
import com.groupoffive.listapp.exceptions.CategoryNotFoundException;
import com.groupoffive.listapp.exceptions.ProductNameAlreadyInUseException;
import com.groupoffive.listapp.models.Produto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/products")
public class ProductsRouter {

    private ProductsController productsController;

    public ProductsRouter(ProductsController productsController) {
        this.productsController = productsController;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, params = { "nome", "preco", "idCategoria" })
    @ResponseBody
    public Produto addProduct(String nome, double preco, int idCategoria) throws ProductNameAlreadyInUseException, CategoryNotFoundException {
        return productsController.addProduct(nome, preco, idCategoria);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, params = { "nome", "preco", "nomeCategoria" })
    @ResponseBody
    public Produto addProduct(String nome, double preco, String nomeCategoria) throws ProductNameAlreadyInUseException, CategoryNameAlreadyInUseException {
        return productsController.addProduct(nome, preco, nomeCategoria);
    }

}