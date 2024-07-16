/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 10:48 PM
 */

package com.pius.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
   private final String msg;
}

