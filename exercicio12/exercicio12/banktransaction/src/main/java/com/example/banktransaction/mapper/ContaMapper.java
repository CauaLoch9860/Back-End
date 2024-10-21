package com.example.banktransaction.mapper;

import com.example.banktransaction.Conta;
import com.example.banktransaction.dto.ContaDTO;

public class ContaMapper {
    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }

    public static Conta toEntity(ContaDTO contaDTO) {
        return new Conta(contaDTO.getCodigo(), contaDTO.getCliente());
    }
}