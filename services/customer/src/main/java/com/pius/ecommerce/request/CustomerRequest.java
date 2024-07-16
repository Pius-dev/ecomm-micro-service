package com.pius.ecommerce.request;

import com.pius.ecommerce.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer firstname is required")
        String firstName,
        @NotNull(message = "Customer firstname is required")
        String lastName,
        @NotNull(message = "Customer firstname is required")
        @Email(message = "Customer email is not valid")
        String email,
        Address address
) {
}
