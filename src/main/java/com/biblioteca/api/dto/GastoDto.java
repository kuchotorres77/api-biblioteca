package com.biblioteca.api.dto;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GastoDto implements Serializable {
    @NotBlank
    private double monto;
    
    @NotBlank
    private String cuenta;
    
    @NotBlank
    private String categoria;
        
    @NotBlank
    private String detalle;
    
    @NotBlank
    private java.util.Date fecha;
}
