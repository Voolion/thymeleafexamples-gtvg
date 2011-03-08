/*
 * =============================================================================
 * 
 *   Copyright (c) 2011, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package thymeleafexamples.gtvg.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import thymeleafexamples.gtvg.business.entities.Product;
import thymeleafexamples.gtvg.business.services.ProductService;

public class ProductListController implements IGTVGController {

    
    public ProductListController() {
        super();
    }
    
    
    public String process(
            final HttpServletRequest request, final HttpServletResponse response,
            final TemplateEngine templateEngine) {
        
        final ProductService productService = new ProductService();
        final List<Product> allProducts = productService.findAll(); 
        
        final WebContext ctx = new WebContext(request, request.getLocale());
        ctx.setVariable("prods", allProducts);
        
        return templateEngine.process("product/list", ctx);
        
    }

}
