package br.unisul.progweb.domain.cliente;

public enum TipoCliente {
    PF(1L, "Pessoa Fisica"),
    PJ(2L, "Pessoa Juridica");

    private Long id;
    private String descricao;

    TipoCliente(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Long cod) {

        if (cod == null) {
            return null;
        }

        for (TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
