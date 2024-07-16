/**
 * Created By Eng. Pius Obonyo
 * Date: 6/12/24
 * Time: 1:09 PM
 */

package com.pius.ecommerce.category;


import com.pius.ecommerce.product.ProductRequest;

import java.util.List;

public interface CategoryService {
    Integer createCategory(CategoryRequest request);

    List<Category> getAllCategories();
}

