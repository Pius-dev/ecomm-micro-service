/**
 * Created By Eng. Pius Obonyo
 * Date: 7/12/24
 * Time: 9:25 PM
 */

package com.pius.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public record Customer(
        String id,
        @NotNull(message = "Firstname is required")
        String firstName,
        @NotNull(message = "Lastname is required")

        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "Customer email not valid")
        String email


) {
}

