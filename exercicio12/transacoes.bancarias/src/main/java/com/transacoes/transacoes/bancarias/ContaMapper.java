package com.transacoes.transacoes.bancarias;
import org.springframework.stereotype.Component;
@Component
public class ContaMapper {
    public ContaDTO toDTO(Conta conta) {
        ContaDTO dto = new ContaDTO();
        dto.setCodigo(conta.getCodigo());
        dto.setCliente(conta.getCliente());
        return dto;
    }
}
