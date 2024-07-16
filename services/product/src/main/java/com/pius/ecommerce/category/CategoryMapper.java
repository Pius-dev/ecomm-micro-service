/**
 * Created By Eng. Pius Obonyo
 * Date: 6/12/24
 * Time: 1:17 PM
 */

package com.pius.ecommerce.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public Category toProduct(CategoryRequest request) {
        return Category.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .build();
    }
}

