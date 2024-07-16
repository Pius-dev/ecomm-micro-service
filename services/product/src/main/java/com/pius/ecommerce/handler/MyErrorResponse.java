package com.pius.ecommerce.handler;

import java.util.Map;

public record MyErrorResponse (
        Map<String, String> errors
) {

}
