/**
 * Created By Eng. Pius Obonyo
 * Date: 6/12/24
 * Time: 1:11 PM
 */

package com.pius.ecommerce.category;

import com.pius.ecommerce.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public Integer createCategory(CategoryRequest request) {
        var product = mapper.toProduct(request);
        return categoryRepository.save(product).getId();
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}

