/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 4:50 PM
 */

package com.pius.ecommerce.orderline;

import com.pius.ecommerce.entity.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private Double quantity;
}

