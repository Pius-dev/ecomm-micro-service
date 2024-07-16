/**
 * Created By Eng. Pius Obonyo
 * Date: 7/12/24
 * Time: 9:08 PM
 */

package com.pius.ecommerce.repository;

import com.pius.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}

