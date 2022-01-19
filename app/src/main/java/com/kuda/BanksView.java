package com.kuda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanksView {
    private String bankName;
    private String bankDetails;
    private int imageId;

}
